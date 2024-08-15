
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fluxvein.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.fluxvein.world.inventory.EndRodGUIMenu;
import net.mcreator.fluxvein.FluxveinMod;

public class FluxveinModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FluxveinMod.MODID);
	public static final RegistryObject<MenuType<EndRodGUIMenu>> END_ROD_GUI = REGISTRY.register("end_rod_gui", () -> IForgeMenuType.create(EndRodGUIMenu::new));
}
