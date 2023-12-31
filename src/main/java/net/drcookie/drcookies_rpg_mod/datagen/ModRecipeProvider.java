package net.drcookie.drcookies_rpg_mod.datagen;


import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.drcookie.drcookies_rpg_mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider  extends FabricRecipeProvider {

    //List containing every thing smeltable with Swamp Iron Ingot as result
    private static final List<ItemConvertible> SWAMP_IRON_INGOT_SMELTABLES = List.of(ModItems.SWAMP_IRON_RAW,
            ModBlocks.SWAMP_IRON_ORE, ModBlocks.DEEPSLATE_SWAMP_IRON_ORE, ModBlocks.NETHER_SWAMP_IRON_ORE,
            ModBlocks.END_STONE_SWAMP_IRON_ORE);



    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //More Examples: RecipeProvider class (MMB click on any)


        /*SWAMP STUFF*/


        //Smelting and Blasting things to swamp iron ingot
        offerSmelting(exporter, SWAMP_IRON_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.SWAMP_IRON_INGOT,
                0.7f, 200, "swamp_iron_ingot");
        offerBlasting(exporter, SWAMP_IRON_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.SWAMP_IRON_INGOT,
                0.7f, 100, "swamp_iron_ingot");


        //Swamp iron ingots to block and vis versa.
        //This way the compacting recipe ids can be changed, the group parameter makes "alternative recipes" function
        //in the recipe book, just like the ones for gold and iron ingots.
        //changing the recipe ids is better, the DataGen sometimes tries to create recipes with the same id if the results is the same
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS, ModItems.SWAMP_IRON_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.SWAMP_IRON_BLOCK,
                "swamp_iron_ingots_to_swamp_iron_block", "swamp_iron_block",
                "swamp_iron_block_to_swamp_iron_ingots","swamp_iron_ingot");


        //Raw swamp iron to block and vis versa
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS, ModItems.SWAMP_IRON_RAW,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.SWAMP_IRON_RAW_BLOCK,
                "swamp_iron_raw_to_swamp_item_raw_block","swamp_iron_raw_block",
                "swamp_iron_raw_block_to_swamp_iron_raw","swamp_iron_raw");


        //Swamp Iron Nuggets to Ingots and vis versa

        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS, ModItems.SWAMP_IRON_NUGGET,
                RecipeCategory.DECORATIONS, ModItems.SWAMP_IRON_INGOT,
                "swamp_iron_nuggets_to_swamp_iron_ingot", "swamp_iron_ingot",
                "swamp_iron_ingot_to_swamp_iron_nuggets", "swamp_iron_nugget");

        //ToDo: Add Recipes for Swamp Iron: Door, Trapdoor, Button, Pressure Plate, (Fence, Fence Gate)
        //ToDo. Add Recipes for Rotting Mud Bricks: Slab, Stairs and Wall

        //using create methods: call .criterion and .offerTo are needed, Ingredients need to be called using Ingredients.ofItems(ID)
        //for example createDoorRecipe()
        //offer methods don't need this




        //Complete Custom Recipe (Category, Output, Count).patterns.inputs.criterion.offerTo
        //might change identifier if multiple recipes have the same output
        //This is an example, deactivate in releases
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SWAMP_IRON_RAW, 1)
                .pattern("SSS")
                .pattern("SIS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('I', ModItems.SWAMP_IRON_INGOT)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.SWAMP_IRON_INGOT), conditionsFromItem(ModItems.SWAMP_IRON_INGOT))
                .group("swamp_iron_raw")
                //.offerTo(exporter, new Identifier(getRecipeName(ModItems.SWAMP_IRON_RAW)));
                .offerTo(exporter, new Identifier("test_craft_swamp_iron_raw"))
                ;

    }
}
