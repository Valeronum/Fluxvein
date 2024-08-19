package net.valeronum.fluxvein.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valeronum.fluxvein.Fluxvein;
import net.valeronum.fluxvein.common.world.FluxveinStarFeature;

public class FVModMiscRegistries {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fluxvein.MODID);

    public static final RegistryObject<CreativeModeTab> FLUXVEIN_TAB = CREATIVE_MODE_TABS.register("fluxvein_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.fluxvein_tab"))
            .icon(() -> FVModItems.FLUXVEIN.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                FVModItems.ITEMS.getEntries().forEach(itemRegistryObject -> output.accept(itemRegistryObject.get()));
                output.accept(FVModBlocks.FLUXVEIN_ORE.get());
            }).build());

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Fluxvein.MODID);
    public static final RegistryObject<Feature<?>> FLUXVEIN_STAR = FEATURES.register("fluxvein_star", FluxveinStarFeature::new);

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
        FEATURES.register(bus);
    }
}