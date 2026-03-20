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
        String state;

        if (Excoriate.ModState.Attention <= 5) state = "unseen";
        else if (Excoriate.ModState.Attention <= 10) state = "noticed";
        else if (Excoriate.ModState.Attention <= 15) state = "watching";
        else state = "focused";

        if (!tag.contains(state)) {
            tag.remove("unseen");
            tag.remove("noticed");
            tag.remove("watching");
            tag.remove("focused");
            tag.putBoolean(state, true);
        }
    }
}
