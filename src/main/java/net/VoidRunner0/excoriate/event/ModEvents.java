package net.VoidRunner0.excoriate.event;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


@Mod.EventBusSubscriber(modid = Excoriate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (entity instanceof Cow || entity instanceof Chicken || entity instanceof Sheep || entity instanceof Pig) {

            double random = Math.random();
            if (random < 0.3) {

                event.getDrops().clear();
                ItemStack drop;

                if (entity instanceof Cow) {
                    drop = new ItemStack(ModItems.LIVING_BEEF.get());
                } else if (entity instanceof Chicken) {
                    drop = new ItemStack(ModItems.LIVING_CHICKEN.get());
                } else if (entity instanceof Sheep) {
                    drop = new ItemStack(ModItems.LIVING_MUTTON.get());
                } else {
                    drop = new ItemStack(ModItems.LIVING_PORK.get());
                }

                event.getDrops().add(
                        new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), drop)
                );
            }
        }
    }
}
