package net.drcookie.drcookies_rpg_mod.datagen;

import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.drcookie.drcookies_rpg_mod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.SWAMP_IRON_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SWAMP_IRON_ORE)
                .add(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE)
                .add(ModBlocks.END_STONE_SWAMP_IRON_ORE)
                .add(ModBlocks.NETHER_SWAMP_IRON_ORE)
                .add(ModBlocks.SOUND_BLOCK)
                .add(ModBlocks.SWAMP_IRON_BLOCK)
                .add(ModBlocks.SWAMP_IRON_RAW_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SWAMP_IRON_ORE)

                .add(ModBlocks.SWAMP_IRON_BLOCK)
                .add(ModBlocks.SWAMP_IRON_RAW_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_SWAMP_IRON_ORE)
        ;

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.END_STONE_SWAMP_IRON_ORE)
        ;

    }
}
