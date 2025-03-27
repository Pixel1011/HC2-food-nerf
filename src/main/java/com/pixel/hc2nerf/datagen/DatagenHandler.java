package com.pixel.hc2nerf.datagen;

import java.util.concurrent.CompletableFuture;

import com.pixel.hc2nerf.HC2Nerf;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, modid = HC2Nerf.MODID)
public class DatagenHandler {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent e) {
    DataGenerator gen = e.getGenerator();
    PackOutput out = gen.getPackOutput();
    ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();

    BlockTagsProvider b = new BlockTags(out, lookupProvider, existingFileHelper);
    gen.addProvider(true, new Translation(out));
    gen.addProvider(true, b);
    gen.addProvider(true, new ItemTags(out, lookupProvider, b.contentsGetter(), existingFileHelper));
  }
}
