package net.valeronum.fluxvein.common;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valeronum.fluxvein.common.items.FluxveinItem;
import net.valeronum.fluxvein.common.items.StoneOfPhasingItem;

@Mod.EventBusSubscriber
public class FVActionsListener {
    @SubscribeEvent
    public static void onPlayerRightClick(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem() instanceof FluxveinItem item)
            item.rightClick(event.getEntity(), event.getItemStack());
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (checkStoneInInventory(player.getInventory())) {
            if (player.getUseItem().getItem() instanceof StoneOfPhasingItem) {
                if (!player.noPhysics)
                    player.noPhysics = true;
                if (!player.isNoGravity())
                    player.setNoGravity(true);
            } else {
                if (player.noPhysics)
                    player.noPhysics = false;
                if (player.isNoGravity())
                    player.setNoGravity(false);
            }
        }
    }

    public static boolean checkStoneInInventory(Inventory inventory) {
        for (int i = 0; i < inventory.getContainerSize() - 1; i++) {
            if (inventory.getItem(i).getItem() instanceof StoneOfPhasingItem)
                return true;
        }
        return false;
    }
}