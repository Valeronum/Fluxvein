package net.valeronum.fluxvein.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.valeronum.fluxvein.common.registries.FVModBlocks;
import net.valeronum.fluxvein.common.registries.FVModItems;

import java.util.function.Consumer;

public class FVRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public FVRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(FVModBlocks.FLUXVEIN_ORE.get()),
                        RecipeCategory.MISC,
                        FVModItems.FLUXVEIN.get(),
                        5, 400
                ).unlockedBy("has_fluxvein_ore", has(FVModBlocks.FLUXVEIN_ORE.get()))
                .save(recipeConsumer);
    }
}