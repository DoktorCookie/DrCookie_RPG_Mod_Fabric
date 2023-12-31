package net.drcookie.drcookies_rpg_mod.datagen;

import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.drcookie.drcookies_rpg_mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.ModStatus;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.SWAMP_IRON_BLOCK);
        addDrop(ModBlocks.SWAMP_IRON_RAW_BLOCK);

        addDrop(ModBlocks.SWAMP_IRON_ORE, copperLikeOreDrops(ModBlocks.SWAMP_IRON_ORE, ModItems.SWAMP_IRON_RAW));
        addDrop(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE, ModItems.SWAMP_IRON_RAW));
        addDrop(ModBlocks.NETHER_SWAMP_IRON_ORE, copperLikeOreDrops(ModBlocks.NETHER_SWAMP_IRON_ORE, ModItems.SWAMP_IRON_RAW));
        addDrop(ModBlocks.END_STONE_SWAMP_IRON_ORE, copperLikeOreDrops(ModBlocks.END_STONE_SWAMP_IRON_ORE, ModItems.SWAMP_IRON_RAW));

        addDrop(ModBlocks.SWAMP_IRON_FENCE);
        addDrop(ModBlocks.SWAMP_IRON_FENCE_GATE);
        addDrop(ModBlocks.SWAMP_IRON_BUTTON);
        addDrop(ModBlocks.SWAMP_IRON_TRAPDOOR);
        addDrop(ModBlocks.SWAMP_IRON_PRESSURE_PLATE);
        addDrop(ModBlocks.SWAMP_IRON_DOOR, doorDrops(ModBlocks.SWAMP_IRON_DOOR));

        addDrop(ModBlocks.ROTTING_MUD_BRICKS_SLAB, slabDrops(ModBlocks.ROTTING_MUD_BRICKS_SLAB));
        addDrop(ModBlocks.ROTTING_MUD_BRICKS_STAIRS);
        addDrop(ModBlocks.ROTTING_MUD_BRICKS_WALL);




    }


    //Use something like this (copied from copperOreDrops and slightly modified) and modify numbers to drop multiple ores
    //the "copper" in the example is hardcoded and an Item needs to be added as parameter
    //BlockLootTableGenerator.java for more examples
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(Items.RAW_COPPER)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
