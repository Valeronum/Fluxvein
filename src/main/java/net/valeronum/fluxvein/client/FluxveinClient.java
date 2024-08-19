package net.valeronum.fluxvein.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.valeronum.fluxvein.Fluxvein;

@Mod.EventBusSubscriber(modid = Fluxvein.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FluxveinClient {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
    }
}