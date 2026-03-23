package net.VoidRunner0.excoriate.datagen;

import net.VoidRunner0.excoriate.Excoriate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Excoriate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}
