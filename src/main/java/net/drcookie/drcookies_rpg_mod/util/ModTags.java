package net.drcookie.drcookies_rpg_mod.util;


import net.drcookie.drcookies_rpg_mod.DrCookiesRPGMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    //Keys needed to reference the json entries in the code


    //Doesn't work anymore?

   // public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS = createTag("metal_detector_detectable_blocks");

    public static class Blocks  {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(DrCookiesRPGMod.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(DrCookiesRPGMod.MOD_ID, name));
        }
    }



}
