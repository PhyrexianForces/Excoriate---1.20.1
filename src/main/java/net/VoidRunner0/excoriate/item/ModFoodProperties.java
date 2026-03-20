package net.VoidRunner0.excoriate.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties LIVING_BEEF = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .meat()
            .build();

    public static final FoodProperties LIVING_CHICKEN = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3F)
            .meat()
            .build();
    public static final FoodProperties LIVING_MUTTON = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3F)
            .meat()
            .build();

    public static final FoodProperties LIVING_PORK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .meat()
            .build();
}
