
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fluxvein.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.fluxvein.block.RodBlock;
import net.mcreator.fluxvein.block.RitualStoneBlock;
import net.mcreator.fluxvein.block.FluxveinOreBlock;
import net.mcreator.fluxvein.block.EndRodBlock;
import net.mcreator.fluxvein.FluxveinMod;

public class FluxveinModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FluxveinMod.MODID);
	public static final RegistryObject<Block> FLUXVEIN_ORE = REGISTRY.register("fluxvein_ore", () -> new FluxveinOreBlock());
	public static final RegistryObject<Block> ROD = REGISTRY.register("rod", () -> new RodBlock());
	public static final RegistryObject<Block> END_ROD = REGISTRY.register("end_rod", () -> new EndRodBlock());
	public static final RegistryObject<Block> RITUAL_STONE = REGISTRY.register("ritual_stone", () -> new RitualStoneBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
