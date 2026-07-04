package com.metheglin.tweaks;

import java.util.Set;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Removes items from the game without unregistering them (which would corrupt
 * existing worlds). Removed items are hidden from the creative inventory,
 * their recipes and block drops are disabled via data overrides, and they
 * cannot be placed or used.
 */
public final class RemovedItems {
	public static final Set<Item> REMOVED_ITEMS = Set.of(
			Items.ENCHANTING_TABLE,
			Items.END_PORTAL_FRAME
	);

	private RemovedItems() {
	}

	static void init() {
		ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {
			entries.getDisplayStacks().removeIf(stack -> REMOVED_ITEMS.contains(stack.getItem()));
			entries.getSearchTabStacks().removeIf(stack -> REMOVED_ITEMS.contains(stack.getItem()));
		});

		UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
			if (REMOVED_ITEMS.contains(player.getItemInHand(hand).getItem())) {
				return InteractionResult.FAIL;
			}

			BlockState state = level.getBlockState(hitResult.getBlockPos());
			// Existing enchanting tables can no longer be opened, and stronghold
			// end portal frames can no longer be filled with eyes of ender.
			if (state.is(Blocks.ENCHANTING_TABLE) || state.is(Blocks.END_PORTAL_FRAME)) {
				return InteractionResult.FAIL;
			}

			return InteractionResult.PASS;
		});
	}
}
