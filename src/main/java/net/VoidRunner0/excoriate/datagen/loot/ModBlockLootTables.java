package net.VoidRunner0.excoriate.datagen.loot;

import net.VoidRunner0.excoriate.block.ModBlocks;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STRAW_HAT.get());
        this.add(ModBlocks.BEEF_BLOCK.get(),
                block -> createOreDrop(ModBlocks.BEEF_BLOCK.get(), ModItems.LIVING_BEEF.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
