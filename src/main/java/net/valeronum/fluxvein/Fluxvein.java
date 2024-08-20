package net.valeronum.fluxvein;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valeronum.fluxvein.common.registries.FVModBlocks;
import net.valeronum.fluxvein.common.registries.FVModItems;
import net.valeronum.fluxvein.common.registries.FVModMiscRegistries;
import org.slf4j.Logger;

@Mod(Fluxvein.MODID)
public class Fluxvein {
    public static final String MODID = "fluxvein";
    public static final Logger LOGGER = LogUtils.getLogger();
    public Fluxvein() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FVModItems.ITEMS.register(bus);
        FVModBlocks.BLOCKS.register(bus);
        FVModMiscRegistries.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}