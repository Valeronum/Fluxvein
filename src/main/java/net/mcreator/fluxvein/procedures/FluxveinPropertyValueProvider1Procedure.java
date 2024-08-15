package net.mcreator.fluxvein.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class FluxveinPropertyValueProvider1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.level().dimension()) == Level.END && Math.sqrt(Math.pow(entity.getX(), 2) + Math.pow(entity.getZ(), 2)) >= 10000) {
			return 1;
		}
		return 0;
	}
}
