package net.VoidRunner0.excoriate.item.custom;

import net.VoidRunner0.excoriate.Excoriate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class LivingMeatItem extends Item {
    public LivingMeatItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Excoriate.ModState.Attention += 1;
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
