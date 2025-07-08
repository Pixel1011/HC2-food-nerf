package com.pixel.hc2nerf;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = HC2Nerf.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder().comment("Pam's Harvest Craft 2 Nerf config:\nREQUIRES RESTART FOR CHANGES TO TAKE EFFECT!\n\n\n");

    private static final ForgeConfigSpec.BooleanValue NERF_PAMS = BUILDER
            .comment("Whether to change all of Pam's HarvestCraft 2 food values to 1.12.2 values").translation("hc2nerf.config.nerfpams")
            .define("nerfpams", true);

    private static final ForgeConfigSpec.BooleanValue NERF_GAMEBREAKING = BUILDER
            .comment("Whether to fix game breaking foods like fresh water, fresh milk, salt, etc").translation("hc2nerf.config.nerfgb")
            .define("nerfgamebreaking", true);

    private static final ForgeConfigSpec.BooleanValue NERF_MINECRAFT = BUILDER
            .comment(
                    "Whether to change default minecraft food values to what Pam's HarvestCraft 2 sets them to in 1.12.2 (nerf)").translation("hc2nerf.config.nerfmc")
            .define("nerfminecraft", false);


    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean nerfPams;
    public static boolean nerfGamebreaking;
    public static boolean nerfMinecraft;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        nerfPams = NERF_PAMS.get();
        nerfGamebreaking = NERF_GAMEBREAKING.get();
        nerfMinecraft = NERF_MINECRAFT.get();
    }

}
