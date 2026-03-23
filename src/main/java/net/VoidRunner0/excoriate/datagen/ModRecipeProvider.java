package net.VoidRunner0.excoriate.datagen;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.block.ModBlocks;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
       ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRAW_HAT.get())
               .pattern(" V ")
               .pattern("WLW")
               .define('V', ModItems.VILE_WHEAT.get())
               .define('W', Items.WHEAT)
               .define('L', Items.LEATHER)
               .unlockedBy(getHasName(ModItems.VILE_WHEAT.get()), has(ModItems.VILE_WHEAT.get()))
               .save(pWriter);
    }
}
