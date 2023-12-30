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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SWAMP_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SWAMP_IRON_RAW_BLOCK);
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
