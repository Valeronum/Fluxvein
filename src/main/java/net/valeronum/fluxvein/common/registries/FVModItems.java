package net.valeronum.fluxvein.common.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.items.FluxveinItem;
import net.valeronum.fluxvein.common.items.StoneOfMirroringItem;
import net.valeronum.fluxvein.common.items.StoneOfPhasingItem;

public class FVModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fluxvein.MODID);
    public static final RegistryObject<Item> RAW_FLUXVEIN = ITEMS.register("raw_fluxvein", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLUXVEIN = ITEMS.register("fluxvein", () -> new FluxveinItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> STONE_OF_PHASING = ITEMS.register("stone_of_phasing", () -> new StoneOfPhasingItem(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> STONE_OF_MIRRORING = ITEMS.register("stone_of_mirroring", () -> new StoneOfMirroringItem(new Item.Properties().rarity(Rarity.RARE)));
}