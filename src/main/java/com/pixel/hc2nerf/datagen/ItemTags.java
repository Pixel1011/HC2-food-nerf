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
import net.minecraftforge.common.data.ExistingFileHelper;

// i do not believe this generates correct files in 1.20.1. as there is not a vanilla method of removing tags :/
public class ItemTags extends ItemTagsProvider {
  public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, blockTags, HC2Nerf.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider lookupProvider) {
    String[] eggItems = new String[]{"pamhc2trees:bananaitem", "pamhc2trees:avocadoitem"};
    String[] grainItems = new String[]{"pamhc2crops:beanitem", "pamhc2crops:chickpeaitem", "pamhc2crops:lentilitem", "pamhc2crops:soybeanitem"};
    String[] vegetableItems = new String[]{"pamhc2trees:avocadoitem"};

    removeTag(eggItems, "forge:egg");
    removeTag(grainItems, "forge:grain");
    removeTag(vegetableItems, "forge:vegetables");

  }

  void removeTag(String[] s_itemsToChange, String s_tagToRemove) {
    ResourceLocation[] itemsToChange = new ResourceLocation[s_itemsToChange.length];
    for (int i = 0; i < itemsToChange.length; i++) {
      itemsToChange[i] = ResourceLocation.tryParse(s_itemsToChange[i]);
    }
    
    ResourceLocation tagToRemove = ResourceLocation.tryParse(s_tagToRemove);
    TagKey<Item> t = TagKey.create(Registries.ITEM, tagToRemove);
    
    for (int i = 0; i < itemsToChange.length; i++) {
      tag(t).remove(itemsToChange[i]);
      TagKey<Item> t2 = TagKey.create(Registries.ITEM, ResourceLocation.tryParse(s_tagToRemove + "/" + s_itemsToChange[i].split(":")[1].replace("item", "") ));
      tag(t2).remove(itemsToChange[i]);
    }
  } 

}
