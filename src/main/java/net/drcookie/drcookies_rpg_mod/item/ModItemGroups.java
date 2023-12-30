package net.drcookie.drcookies_rpg_mod.item;

import net.drcookie.drcookies_rpg_mod.DrCookiesRPGMod;
import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import javax.sound.midi.MidiChannel;

public class ModItemGroups {


    public static final ItemGroup DRCOOKIE_RPG_MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_misc"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_misc"))
                    .icon( () -> new ItemStack(ModItems.COIN_COPPER)).entries((displayContext, entries) -> {

                        entries.add(ModItems.COIN_COPPER);

                    }).build()

    );

    public static final ItemGroup DRCOOKIE_RPG_DEV_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_dev"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_dev"))
                    .icon( () -> new ItemStack(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE)).entries((displayContext, entries) -> {

                        //Ores for test purposes
                        entries.add(ModBlocks.DEEPSLATE_SWAMP_IRON_ORE);
                        entries.add(ModBlocks.NETHER_SWAMP_IRON_ORE);
                        entries.add(ModBlocks.END_STONE_SWAMP_IRON_ORE);

                        //Metal Detector as an example for an advanced item
                        entries.add(ModItems.METAL_DETECTOR);
                        //Sound Block as an example for an advanced block
                        entries.add(ModBlocks.SOUND_BLOCK);


                    }).build()

    );

    public static final ItemGroup DRCOOKIE_RPG_BIOME_ADDITIONS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_biome_additions"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_biome_additions"))
                    .icon( () -> new ItemStack(ModBlocks.SWAMP_IRON_ORE)).entries((displayContext, entries) -> {



                        //Swamp Stuff
                        entries.add(ModBlocks.SWAMP_IRON_ORE);
                        entries.add(ModBlocks.SWAMP_IRON_RAW_BLOCK);
                        entries.add(ModBlocks.SWAMP_IRON_BLOCK);
                        entries.add(ModItems.SWAMP_IRON_RAW);
                        entries.add(ModItems.SWAMP_IRON_INGOT);
                        entries.add(ModItems.SWAMP_IRON_NUGGET);

                        entries.add(ModItems.ROTTING_MUD);

                        entries.add(ModItems.SLIME_BERRY);

                        //Dessert Stuff
                        entries.add(ModItems.COMBUSTILY_BUD);

                    }).build()

    );



    public static void registerItemGroups(){

        DrCookiesRPGMod.LOGGER.info("Registering Item Groups for " + DrCookiesRPGMod.MOD_ID);

    }

}
