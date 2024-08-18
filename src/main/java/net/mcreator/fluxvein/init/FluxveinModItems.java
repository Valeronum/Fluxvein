
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fluxvein.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.fluxvein.procedures.FluxveinPropertyValueProvider1Procedure;
import net.mcreator.fluxvein.item.FluxveinItem;
import net.mcreator.fluxvein.item.EndFluxveinItem;
import net.mcreator.fluxvein.item.EndFluxveinActiveItem;
import net.mcreator.fluxvein.FluxveinMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FluxveinModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FluxveinMod.MODID);
	public static final RegistryObject<Item> FLUXVEIN_ORE = block(FluxveinModBlocks.FLUXVEIN_ORE);
	public static final RegistryObject<Item> FLUXVEIN = REGISTRY.register("fluxvein", () -> new FluxveinItem());
	public static final RegistryObject<Item> END_FLUXVEIN = REGISTRY.register("end_fluxvein", () -> new EndFluxveinItem());
	public static final RegistryObject<Item> END_FLUXVEIN_ACTIVE = REGISTRY.register("end_fluxvein_active", () -> new EndFluxveinActiveItem());
	public static final RegistryObject<Item> ROD = block(FluxveinModBlocks.ROD);
	public static final RegistryObject<Item> END_ROD = block(FluxveinModBlocks.END_ROD);
	public static final RegistryObject<Item> RITUAL_STONE = block(FluxveinModBlocks.RITUAL_STONE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(FLUXVEIN.get(), new ResourceLocation("fluxvein:fluxvein_fluxvein_a1"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) FluxveinPropertyValueProvider1Procedure.execute(entity));
		});
	}
}
