package net.valeronum.fluxvein.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.registries.FVModItems;

public class FVModItemModelProvider extends ItemModelProvider {
    public FVModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Fluxvein.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(FVModItems.FLUXVEIN);
        simpleItem(FVModItems.RAW_FLUXVEIN);
        simpleItem(FVModItems.STONE_OF_MIRRORING);
        simpleItem(FVModItems.STONE_OF_PHASING);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Fluxvein.MODID,"item/" + item.getId().getPath()));
    }
}