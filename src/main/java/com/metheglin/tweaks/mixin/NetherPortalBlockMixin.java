package com.metheglin.tweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.portal.TeleportTransition;

/**
 * Disables the Nether dimension: standing in a nether portal never resolves a
 * destination, so no entity can ever travel through one.
 */
@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin {
	@Inject(method = "getPortalDestination", at = @At("HEAD"), cancellable = true)
	private void metheglins_tweaks$disableNetherTravel(ServerLevel level, Entity entity, BlockPos pos,
			CallbackInfoReturnable<TeleportTransition> cir) {
		cir.setReturnValue(null);
	}
}
