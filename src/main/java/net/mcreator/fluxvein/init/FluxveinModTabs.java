
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fluxvein.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.fluxvein.FluxveinMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluxveinModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FluxveinMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(FluxveinModBlocks.FLUXVEIN_ORE.get().asItem());
			tabData.accept(FluxveinModItems.FLUXVEIN.get());
			tabData.accept(FluxveinModItems.END_FLUXVEIN.get());
			tabData.accept(FluxveinModItems.END_FLUXVEIN_ACTIVE.get());
			tabData.accept(FluxveinModBlocks.ROD.get().asItem());
			tabData.accept(FluxveinModBlocks.END_ROD.get().asItem());
		}
	}
}
