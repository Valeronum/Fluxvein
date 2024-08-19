package net.valeronum.fluxvein.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.registries.FVModConfiguredFeatures;
import net.valeronum.fluxvein.common.registries.FVModPlacements;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FVModRegistryProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, FVModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, FVModPlacements::bootstrap);

    public FVModRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Fluxvein.MODID));
    }
}