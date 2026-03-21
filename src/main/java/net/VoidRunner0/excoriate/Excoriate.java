package net.VoidRunner0.excoriate;

import com.mojang.logging.LogUtils;
import net.VoidRunner0.excoriate.block.ModBlocks;
import net.VoidRunner0.excoriate.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Excoriate.MOD_ID)
public class Excoriate {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "excoriate";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Excoriate(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register things here:
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public class ModState {
        public static int Attention = 0;
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.LIVING_BEEF);
            event.accept(ModItems.LIVING_CHICKEN);
            event.accept(ModItems.LIVING_MUTTON);
            event.accept(ModItems.LIVING_PORK);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.VILE_WHEAT);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRAW_HAT.get(), RenderType.cutout());

                ItemProperties.register(
                        ModItems.DOLL.get(),
                        ResourceLocation.fromNamespaceAndPath("excoriate", "unseen"),
                        (stack, level, entity, seed) ->
                                stack.getOrCreateTag().getBoolean("unseen") ? 1.0F : 0.0F);
                ItemProperties.register(
                        ModItems.DOLL.get(),
                        ResourceLocation.fromNamespaceAndPath("excoriate", "noticed"),
                        (stack, level, entity, seed) ->
                                stack.getOrCreateTag().getBoolean("noticed") ? 1.0F : 0.0F);
                ItemProperties.register(
                        ModItems.DOLL.get(),
                        ResourceLocation.fromNamespaceAndPath("excoriate", "watching"),
                        (stack, level, entity, seed) ->
                                stack.getOrCreateTag().getBoolean("watching") ? 1.0F : 0.0F);
                ItemProperties.register(
                        ModItems.DOLL.get(),
                        ResourceLocation.fromNamespaceAndPath("excoriate", "focused"),
                        (stack, level, entity, seed) ->
                                stack.getOrCreateTag().getBoolean("focused") ? 1.0F : 0.0F);});
        }
    }
}
