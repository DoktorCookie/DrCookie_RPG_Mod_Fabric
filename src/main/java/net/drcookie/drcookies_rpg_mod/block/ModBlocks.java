package net.drcookie.drcookies_rpg_mod.block;

import net.drcookie.drcookies_rpg_mod.DrCookiesRPGMod;
import net.drcookie.drcookies_rpg_mod.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    /*SWAMP STUFF*/

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
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.PALE_GREEN)));


    //Swamp Iron Blocks and nonBlockBlocks
    public static final Block SWAMP_IRON_BLOCK = registerBlock("swamp_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.PALE_GREEN)));
    public static final Block SWAMP_IRON_BUTTON = registerBlock("swamp_iron_button",
            new ButtonBlock(BlockSetType.IRON,10 ,FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK)));
    public static final Block SWAMP_IRON_PRESSURE_PLATE = registerBlock("swamp_iron_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK)));
    public static final Block SWAMP_IRON_FENCE = registerBlock("swamp_iron_fence",
            new FenceBlock(FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK)));
    public static final Block SWAMP_IRON_FENCE_GATE = registerBlock("swamp_iron_fence_gate",
            new FenceGateBlock(WoodType.ACACIA ,FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK)));
    public static final Block SWAMP_IRON_DOOR = registerBlock("swamp_iron_door",
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK).nonOpaque()));
    public static final Block SWAMP_IRON_TRAPDOOR = registerBlock("swamp_iron_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(ModBlocks.SWAMP_IRON_BLOCK).nonOpaque()));
    //ToDo: Add Swamp Iron Bars and remove the fence, fence gate if not needed as template anymore


    //Swamp Iron Ore and Variants
    //UniformIntProvider: Defines EXP values
    public static final Block SWAMP_IRON_ORE = registerBlock("swamp_iron_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    //3 Variants for testing purposes
    public static final Block DEEPSLATE_SWAMP_IRON_ORE = registerBlock("deepslate_swamp_iron_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));
    public static final Block NETHER_SWAMP_IRON_ORE = registerBlock("nether_swamp_iron_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1f)));
    public static final Block END_STONE_SWAMP_IRON_ORE = registerBlock("end_stone_swamp_iron_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f)));

    //Rotting Mud Bricks and derivatives
    public static final Block ROTTING_MUD_BRICKS = registerBlock("rotting_mud_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).mapColor(MapColor.DIRT_BROWN)));
    public static final Block ROTTING_MUD_BRICKS_STAIRS = registerBlock("rotting_mud_bricks_stairs",
            new StairsBlock(ModBlocks.ROTTING_MUD_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.ROTTING_MUD_BRICKS)));
    public static final Block ROTTING_MUD_BRICKS_SLAB = registerBlock("rotting_mud_bricks_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.ROTTING_MUD_BRICKS)));
    public static final Block ROTTING_MUD_BRICKS_WALL = registerBlock("rotting_mud_bricks_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.ROTTING_MUD_BRICKS)));




    /*DEV STUFF*/

    //advanced block as a test
    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));















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
