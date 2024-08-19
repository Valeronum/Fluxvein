package net.valeronum.fluxvein.common.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.items.FluxveinItem;

public class FVModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fluxvein.MODID);
    public static final RegistryObject<Item> FLUXVEIN = ITEMS.register("fluxvein", () -> new FluxveinItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
}