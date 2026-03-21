package net.VoidRunner0.excoriate.block;

import net.VoidRunner0.excoriate.Excoriate;
import net.VoidRunner0.excoriate.block.custom.StrawHat;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Excoriate.MOD_ID);

    public static final RegistryObject<Block> BEEF_BLOCK = registerBlock("beef_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.MUD).strength(1f).ignitedByLava()));

    public static final RegistryObject<Block> STRAW_HAT = registerBlock("straw_hat",
        () -> new StrawHat(BlockBehaviour.Properties.of()
                .sound(SoundType.GRASS).strength(0.1f).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
