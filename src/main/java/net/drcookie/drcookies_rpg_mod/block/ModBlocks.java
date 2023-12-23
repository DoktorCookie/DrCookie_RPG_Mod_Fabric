package net.drcookie.drcookies_rpg_mod.block;

import net.drcookie.drcookies_rpg_mod.DrCookiesRPGMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SWAMP_IRON_RAW_BLOCK = registerBlock("swamp_iron_raw_block",

            //This copies the settings of a block
            //new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

            //This creates new settings
            /*
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(Instrument.IRON_XYLOPHONE)
                    .requiresTool()
                    .strength(5.0f, 6.0f)
                    .sounds(BlockSoundGroup.METAL)
            ));*/

            //This copies Block Settings and changes a single entry
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.PALE_GREEN)));


    public static final Block SWAMP_IRON_ORE = registerBlock("swamp_iron_ore",

            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));


    private static Block registerBlock(String name, Block block){

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DrCookiesRPGMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(DrCookiesRPGMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));


    }



    public static void registerModBlocks() {

        DrCookiesRPGMod.LOGGER.info("Registering ModBlocks for " + DrCookiesRPGMod.MOD_ID);

    }


}
