package net.valeronum.fluxvein.common.registries;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;

import java.util.function.Supplier;

public class FVModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fluxvein.MODID);
    public static final RegistryObject<Block> FLUXVEIN_ORE = registerBlock("fluxvein_ore", () -> new DropExperienceBlock(
            BlockBehaviour.Properties.of().strength(2.5f, 2.5f).lightLevel(s -> 4), UniformInt.of(1, 7)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return FVModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}