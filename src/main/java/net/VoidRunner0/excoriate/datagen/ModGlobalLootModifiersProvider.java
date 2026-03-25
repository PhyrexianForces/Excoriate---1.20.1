package net.VoidRunner0.excoriate.datagen;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.item.ModItems;
import net.VoidRunner0.excoriate.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Excoriate.MOD_ID);
    }

    @Override
    protected void start() {
        add("beef_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, Items.BEEF));
        add("chicken_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, Items.CHICKEN));
        add("mutton_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, Items.MUTTON));
        add("pork_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, Items.PORKCHOP));

        add("doll_from_plains_house", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.15f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village_plains_house")).build()}, ModItems.DOLL.get()));
    }
}
