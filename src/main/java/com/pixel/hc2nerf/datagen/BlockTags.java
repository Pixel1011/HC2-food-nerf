package com.pixel.hc2nerf.datagen;

import java.util.concurrent.CompletableFuture;

import com.pixel.hc2nerf.HC2Nerf;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {
  public BlockTags(PackOutput o, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
    super(o, lookupProvider, HC2Nerf.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider lookupProvider) {
    // do nothing and pray i guess?
    return;
  };
}
