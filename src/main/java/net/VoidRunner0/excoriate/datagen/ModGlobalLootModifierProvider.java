package net.VoidRunner0.excoriate.datagen;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.datagen.loot.AddItemModifier;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Excoriate.MOD_ID);
    }

    @Override
    protected void start() {
        add("living_beef_from_cow", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/cow")).build()}, ModItems.LIVING_BEEF.get()));
    }
}
