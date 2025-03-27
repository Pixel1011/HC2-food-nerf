package com.pixel.hc2nerf.datagen;

import com.pixel.hc2nerf.HC2Nerf;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class Translation extends LanguageProvider {
  public Translation(PackOutput out) {
    super(out, HC2Nerf.MODID, "en_us");
  }

  @Override
  protected void addTranslations() {
    add("hc2nerf.config.nerfpams", "Nerf food values");
    add("hc2nerf.config.nerfgb", "Nerf game breaking foods");
    add("hc2nerf.config.nerfmc", "Nerf minecraft foods");
    add("hc2nerf.config.nerfpams.tooltip", "Whether to change all of Pam's HarvestCraft 2 food values to 1.12.2 values");
  }
}
