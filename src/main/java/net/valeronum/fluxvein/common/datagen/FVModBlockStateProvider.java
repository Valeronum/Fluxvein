package net.valeronum.fluxvein.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.registries.FVModBlocks;

public class FVModBlockStateProvider extends BlockStateProvider {
    public FVModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Fluxvein.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(FVModBlocks.FLUXVEIN_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}