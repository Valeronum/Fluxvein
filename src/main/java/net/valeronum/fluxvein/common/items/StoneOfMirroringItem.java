package net.valeronum.fluxvein.common.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class StoneOfMirroringItem extends FluxveinItem {
    public StoneOfMirroringItem(Properties properties) {
        super(properties);
    }

    @Override
    public void rightClick(Player player, ItemStack stack) {
        List<Entity> entities = player.level().getEntitiesOfClass(Entity.class,new AABB(player.getOnPos(),player.getOnPos()).inflate(9));
        for (Entity entity : entities) {
            if (entity instanceof Projectile projectile)
                projectile.setDeltaMovement(new Vec3(0,1,0));
        }
        player.level().playSound(player,player.getOnPos(), SoundEvents.VEX_HURT, SoundSource.PLAYERS,2,2);
        for (int i = 0; i < 360; i++) {
            if (i % 20 == 0)
                player.level().addParticle(ParticleTypes.END_ROD, player.getX() + 0.25, player.getY()+1, player.getZ() + 0.25,
                        Math.cos(i) * 0.5d, 0.2d, Math.sin(i) * 0.5d);
        }
    }
}