package com.metheglin.tweaks.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.portal.PortalShape;

/**
 * Prevents nether portals from ever being lit: an obsidian frame is never
 * recognized as a valid empty portal shape, regardless of the ignition source
 * (flint and steel, fire spread, ghast fireballs, dispensers, ...).
 */
@Mixin(PortalShape.class)
public abstract class PortalShapeMixin {
	@Inject(method = "findEmptyPortalShape", at = @At("HEAD"), cancellable = true)
	private static void metheglins_tweaks$preventPortalIgnition(LevelAccessor level, BlockPos pos,
			Direction.Axis axis, CallbackInfoReturnable<Optional<PortalShape>> cir) {
		cir.setReturnValue(Optional.empty());
	}
}
