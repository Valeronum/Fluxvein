package net.valeronum.fluxvein.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.valeronum.fluxvein.common.FVActionsListener;
import net.valeronum.fluxvein.common.items.StoneOfPhasingItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "isColliding", at = @At("HEAD"), cancellable = true)
    private void onIsColliding(BlockPos pPos, BlockState pState, CallbackInfoReturnable<Boolean> cir) {
        Entity entity = ((Entity) (Object) this);
        if (entity instanceof Player player && FVActionsListener.checkStoneInInventory(player.getInventory())) {
            if (player.isUsingItem() && player.getUseItem().getItem() instanceof StoneOfPhasingItem)
                cir.setReturnValue(false);
            else
                cir.setReturnValue(cir.getReturnValue());
        }
    }
    @Inject(method = "push(Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"), cancellable = true)
    public void push(Entity pEntity, CallbackInfo ci){
        if (pEntity instanceof Player player && FVActionsListener.checkStoneInInventory(player.getInventory())) {
            if (player.isUsingItem() && player.getUseItem().getItem() instanceof StoneOfPhasingItem)
                ci.cancel();
        };
    }
}