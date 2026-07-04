package com.metheglin.tweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.portal.TeleportTransition;

/**
 * Disables the End dimension: an end portal block never resolves a
 * destination, so no entity can ever fall through into the End.
 */
@Mixin(EndPortalBlock.class)
public abstract class EndPortalBlockMixin {
	@Inject(method = "getPortalDestination", at = @At("HEAD"), cancellable = true)
	private void metheglins_tweaks$disableEndTravel(ServerLevel level, Entity entity, BlockPos pos,
			CallbackInfoReturnable<TeleportTransition> cir) {
		cir.setReturnValue(null);
	}
}
