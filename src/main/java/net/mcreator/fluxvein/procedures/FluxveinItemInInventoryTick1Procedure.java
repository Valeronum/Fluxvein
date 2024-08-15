package net.mcreator.fluxvein.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class FluxveinItemInInventoryTick1Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.END && Math.sqrt(Math.pow(entity.getX(), 2) + Math.pow(entity.getZ(), 2)) >= 10000) {
			itemstack.getOrCreateTag().putDouble("end_active_distance", 1);
		} else {
			itemstack.getOrCreateTag().putDouble("end_active_distance", 0);
		}
	}
}
