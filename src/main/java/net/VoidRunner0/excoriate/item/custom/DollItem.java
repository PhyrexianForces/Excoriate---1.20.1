package net.VoidRunner0.excoriate.item.custom;

import net.VoidRunner0.excoriate.Excoriate;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DollItem extends Item {
    public DollItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        CompoundTag tag = pStack.getOrCreateTag();

        if (!pEntity.level().isClientSide) {
            if (Excoriate.ModState.Attention <= 5) {
                pStack.getOrCreateTag().putBoolean("unseen", true);
                pStack.getOrCreateTag().remove("noticed");
                pStack.getOrCreateTag().remove("watching");
                pStack.getOrCreateTag().remove("focused");
            } else if (Excoriate.ModState.Attention <= 10) {
                pStack.getOrCreateTag().putBoolean("noticed", true);
                pStack.getOrCreateTag().remove("unseen");
                pStack.getOrCreateTag().remove("watching");
                pStack.getOrCreateTag().remove("focused");
            } else if (Excoriate.ModState.Attention <= 15) {
                pStack.getOrCreateTag().putBoolean("watching", true);
                pStack.getOrCreateTag().remove("unseen");
                pStack.getOrCreateTag().remove("noticed");
                pStack.getOrCreateTag().remove("focused");
            } else {
                pStack.getOrCreateTag().putBoolean("focused", true);
                pStack.getOrCreateTag().remove("unseen");
                pStack.getOrCreateTag().remove("noticed");
                pStack.getOrCreateTag().remove("watching");
            }
        }
    }
}
