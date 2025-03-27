package com.pixel.hc2nerf.datagen;

import java.util.concurrent.CompletableFuture;

import com.pixel.hc2nerf.HC2Nerf;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {
  public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, blockTags, HC2Nerf.MODID, existingFileHelper);
  }

  @SuppressWarnings("null")
  @Override
  protected void addTags(HolderLookup.Provider lookupProvider) {
    String[] eggItems = new String[]{"pamhc2trees:bananaitem", "pamhc2trees:avocadoitem"};
    String[] grainItems = new String[]{"pamhc2crops:beanitem", "pamhc2crops:chickpeaitem", "pamhc2crops:lentilitem", "pamhc2crops:soybeanitem"};
    String[] vegetableItems = new String[]{"pamhc2trees:avocadoitem"};

    removeTag(eggItems, "c:egg");
    removeTag(grainItems, "c:grain");
    removeTag(vegetableItems, "c:vegetables");

  }

  void removeTag(String[] s_itemsToChange, String s_tagToRemove) {
    ResourceLocation[] itemsToChange = new ResourceLocation[s_itemsToChange.length];
    for (int i = 0; i < itemsToChange.length; i++) {
      itemsToChange[i] = ResourceLocation.parse(s_itemsToChange[i]);
    }
    
    ResourceLocation tagToRemove = ResourceLocation.parse(s_tagToRemove);
    TagKey<Item> t = TagKey.create(Registries.ITEM, tagToRemove);
    
    for (int i = 0; i < itemsToChange.length; i++) {
      tag(t).remove(itemsToChange[i]);
      TagKey<Item> t2 = TagKey.create(Registries.ITEM, ResourceLocation.parse(s_tagToRemove + "/" + s_itemsToChange[i].split(":")[1].replace("item", "") ));
      tag(t2).remove(itemsToChange[i]);
    }
  } 

}
