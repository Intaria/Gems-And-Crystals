package com.coliwogg.gemsandcrystals;

import com.coliwogg.gemsandcrystals.block.ModBlocks;
import com.coliwogg.gemsandcrystals.item.ModCreativeModeTabs;
import com.coliwogg.gemsandcrystals.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GemsAndCrystals.MOD_ID)
public class GemsAndCrystals {
    public static final String MOD_ID = "gemsandcrystals";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GemsAndCrystals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.TOPAZ);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.TOPAZ_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
            event.accept(ModBlocks.TOPAZ_ORE);
            event.accept(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        }


        if (event.getTab() == ModCreativeModeTabs.GEMS_AND_CRYSTALS_TAB) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.TOPAZ);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.TOPAZ_BLOCK);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
            event.accept(ModBlocks.TOPAZ_ORE);
            event.accept(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
