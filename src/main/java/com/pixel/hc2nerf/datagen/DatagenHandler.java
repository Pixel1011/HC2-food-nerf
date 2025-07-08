package com.pixel.hc2nerf.datagen;

import java.util.concurrent.CompletableFuture;

import com.pixel.hc2nerf.HC2Nerf;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.common.data.BlockTagsProvider;


@EventBusSubscriber(modid = HC2Nerf.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DatagenHandler {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent e) {
    System.out.println("running datagen");
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
