package net.valeronum.fluxvein.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valeronum.fluxvein.Fluxvein;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Fluxvein.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FVDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(event.includeClient(), new FVModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new FVModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new FVModRegistryProvider(packOutput, lookupProvider));
        generator.addProvider(true,new FVLangProvider(packOutput,"en_us",false));
        generator.addProvider(true,new FVRecipeProvider(packOutput));
    }
}