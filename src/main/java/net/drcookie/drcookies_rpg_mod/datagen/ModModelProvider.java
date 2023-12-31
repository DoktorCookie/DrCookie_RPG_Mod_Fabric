package net.drcookie.drcookies_rpg_mod.datagen;

import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.drcookie.drcookies_rpg_mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {


    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //Swamp Stuff
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SWAMP_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SWAMP_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_SWAMP_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SWAMP_IRON_RAW_BLOCK);

        BlockStateModelGenerator.BlockTexturePool swampIronPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SWAMP_IRON_BLOCK);
        BlockStateModelGenerator.BlockTexturePool rottingMudBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROTTING_MUD_BRICKS);

        swampIronPool.fence(ModBlocks.SWAMP_IRON_FENCE);
        swampIronPool.fenceGate(ModBlocks.SWAMP_IRON_FENCE_GATE);
        swampIronPool.button(ModBlocks.SWAMP_IRON_BUTTON);
        swampIronPool.pressurePlate(ModBlocks.SWAMP_IRON_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.SWAMP_IRON_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SWAMP_IRON_TRAPDOOR);

        rottingMudBricksPool.slab(ModBlocks.ROTTING_MUD_BRICKS_SLAB);
        rottingMudBricksPool.stairs(ModBlocks.ROTTING_MUD_BRICKS_STAIRS);
        rottingMudBricksPool.wall(ModBlocks.ROTTING_MUD_BRICKS_WALL);

        //Dev Stuff
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        //Swamp Stuff
        itemModelGenerator.register(ModItems.SWAMP_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWAMP_IRON_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWAMP_IRON_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIME_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROTTING_MUD, Models.GENERATED);
        //Dessert Stuff
        itemModelGenerator.register(ModItems.COMBUSTILY_BUD, Models.GENERATED);
        //Misc Stuff
        itemModelGenerator.register(ModItems.COIN_COPPER, Models.GENERATED);
        //Dev Stuff
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

    }
}
