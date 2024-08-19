package net.valeronum.fluxvein.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.world.FluxveinStarFeature;

public class FVModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUXVEIN_STARS = registerKey("fluxvein_stars");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context,FLUXVEIN_STARS,new FluxveinStarFeature(), NoneFeatureConfiguration.INSTANCE);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Fluxvein.MODID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}