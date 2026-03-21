package net.VoidRunner0.excoriate.event;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Excoriate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Cow || event.getEntity() instanceof Chicken || event.getEntity() instanceof Sheep || event.getEntity() instanceof Pig) {
            double random = Math.random();
            if (random > 0.3) {
                LivingEntity entity = event.getEntity();
                Level level = entity.level();
                ItemStack beef = new ItemStack(ModItems.LIVING_BEEF.get());
                ItemStack chicken = new ItemStack(ModItems.LIVING_CHICKEN.get());
                ItemStack mutton = new ItemStack(ModItems.LIVING_MUTTON.get());
                ItemStack pork = new ItemStack(ModItems.LIVING_PORK.get());
            }
        }
    }
}
