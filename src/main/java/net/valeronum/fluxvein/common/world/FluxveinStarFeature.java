package net.valeronum.fluxvein.common.world;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.valeronum.fluxvein.common.registries.FVModBlocks;

public class FluxveinStarFeature extends Feature<NoneFeatureConfiguration> {
    public FluxveinStarFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> placeContext) {
        WorldGenLevel level = placeContext.level();
        BlockPos origin = placeContext.origin();
        RandomSource random = placeContext.random();
        int baseRadius = 5;
        int tentacleHeight = 20 + random.nextInt(10);
        BlockPos currentPos = origin;
        for (int y = tentacleHeight; y > 0; y--) {
            int sideRadius = 2 + random.nextInt(2);
            int currentRadius = (int) ((1.0 - (double) y / tentacleHeight) * baseRadius) + sideRadius;

            for (int x = -currentRadius; x <= currentRadius; x++) {
                for (int z = -currentRadius; z <= currentRadius; z++) {
                    if (x * x + z * z <= currentRadius * currentRadius) {
                        BlockPos pos = currentPos.offset(x, y, z);
                        level.setBlock(pos, Blocks.END_STONE.defaultBlockState(), 2);
                        if (random.nextFloat() > 0.875)
                            level.setBlock(pos.below(), random.nextBoolean() ?
                                    FVModBlocks.FLUXVEIN_ORE.get().defaultBlockState() : Blocks.END_STONE.defaultBlockState(), 3);
                    }
                }
            }
            currentPos = currentPos.above().offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
        }
        return true;
    }
}