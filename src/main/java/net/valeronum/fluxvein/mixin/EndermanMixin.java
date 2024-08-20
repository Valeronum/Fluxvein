package net.valeronum.fluxvein.mixin;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.valeronum.fluxvein.common.items.FluxveinItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public class EndermanMixin {
    @Inject(method = "isLookingAtMe",at=@At("HEAD"), cancellable = true)
    public void isLookingAtEnderman(Player pPlayer, CallbackInfoReturnable<Boolean> cir){
        if (pPlayer.getMainHandItem().getItem() instanceof FluxveinItem ||
                pPlayer.getOffhandItem().getItem() instanceof FluxveinItem)
            cir.setReturnValue(false);
    }
}