package net.VoidRunner0.excoriate.item;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.item.custom.DollItem;
import net.VoidRunner0.excoriate.item.custom.LivingMeatItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Excoriate.MOD_ID);

    public static final RegistryObject<Item> LIVING_BEEF = ITEMS.register("living_beef",
            () -> new LivingMeatItem(new Item.Properties().food(ModFoodProperties.LIVING_BEEF)));
    public static final RegistryObject<Item> LIVING_CHICKEN = ITEMS.register("living_chicken",
            () -> new LivingMeatItem(new Item.Properties().food(ModFoodProperties.LIVING_CHICKEN)));
    public static final RegistryObject<Item> LIVING_MUTTON = ITEMS.register("living_mutton",
            () -> new LivingMeatItem(new Item.Properties().food(ModFoodProperties.LIVING_MUTTON)));
    public static final RegistryObject<Item> LIVING_PORK = ITEMS.register("living_pork",
            () -> new LivingMeatItem(new Item.Properties().food(ModFoodProperties.LIVING_PORK)));

    public static final RegistryObject<Item> DOLL = ITEMS.register("doll",
            () -> new DollItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
