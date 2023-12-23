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

public class ModItemGroups {

    public static final ItemGroup DRCOOKIE_RPG_INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_ingredients"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_ingredients"))
                    .icon( () -> new ItemStack(ModItems.SWAMP_IRON_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.SWAMP_IRON_RAW);
                        entries.add(ModItems.SWAMP_IRON_INGOT);


                    }).build()

    );

    public static final ItemGroup DRCOOKIE_RPG_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_blocks"))
                    .icon( () -> new ItemStack(ModBlocks.SWAMP_IRON_ORE)).entries((displayContext, entries) -> {


                        entries.add(ModBlocks.SWAMP_IRON_RAW_BLOCK);
                        entries.add(ModBlocks.SWAMP_IRON_ORE);

                    }).build()

    );

    public static final ItemGroup DRCOOKIE_RPG_MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DrCookiesRPGMod.MOD_ID, "rpg_misc"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_misc"))
                    .icon( () -> new ItemStack(ModItems.COIN_COPPER)).entries((displayContext, entries) -> {

                        entries.add(ModItems.COIN_COPPER);

                    }).build()

    );


    public static void registerItemGroups(){

        DrCookiesRPGMod.LOGGER.info("Registering Item Groups for " + DrCookiesRPGMod.MOD_ID);

    }

}
