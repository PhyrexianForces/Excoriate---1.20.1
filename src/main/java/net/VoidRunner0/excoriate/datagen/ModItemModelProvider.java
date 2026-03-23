package net.VoidRunner0.excoriate.datagen;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Excoriate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.LIVING_BEEF);
        simpleItem(ModItems.LIVING_CHICKEN);
        simpleItem(ModItems.LIVING_MUTTON);
        simpleItem(ModItems.LIVING_PORK);

        simpleItem(ModItems.DOLL);
        simpleItem(ModItems.VILE_WHEAT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(Excoriate.MOD_ID,"item/" + item.getId().getPath()));
    }
}
