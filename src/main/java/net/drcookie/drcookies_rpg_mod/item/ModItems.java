package net.drcookie.drcookies_rpg_mod.item;

import net.drcookie.drcookies_rpg_mod.DrCookiesRPGMod;
import net.drcookie.drcookies_rpg_mod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Swamp Stuff

    public static final Item SWAMP_IRON_RAW = registerItem("swamp_iron_raw", new Item( new FabricItemSettings()));
    public static final Item SWAMP_IRON_INGOT = registerItem("swamp_iron_ingot", new Item( new FabricItemSettings()));
    public static final Item SWAMP_IRON_NUGGET = registerItem("swamp_iron_nugget", new Item( new FabricItemSettings()));
    public static final Item ROTTING_MUD = registerItem("rotting_mud", new Item( new FabricItemSettings()));
    public static final Item SLIME_BERRY = registerItem("slime_berry", new Item( new FabricItemSettings()
            .food(ModFoodComponents.SLIME_BERRY)));
    //Dessert Stuff
    public static final Item COMBUSTILY_BUD = registerItem("combustily_bud", new Item( new FabricItemSettings()));





    //Misc Stuff

    public static final Item COIN_COPPER = registerItem("coin_copper", new Item( new FabricItemSettings()));





    //example for an advanced item with own class and maximum durability
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem( new FabricItemSettings().maxDamage(64)));



    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

        entries.add(SWAMP_IRON_RAW);
        entries.add(SWAMP_IRON_INGOT);

    }

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier(DrCookiesRPGMod.MOD_ID, name), item);

    }

    public static void registerModItems() {

        DrCookiesRPGMod.LOGGER.info("Registering Mod Items for " + DrCookiesRPGMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);

    }

}


