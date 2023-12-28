package net.drcookie.drcookies_rpg_mod;

import net.drcookie.drcookies_rpg_mod.block.ModBlocks;
import net.drcookie.drcookies_rpg_mod.item.ModItemGroups;
import net.drcookie.drcookies_rpg_mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrCookiesRPGMod implements ModInitializer {

	public static final String MOD_ID = "drcookies_rpg_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//For multiple fuels, put them inn a separate class and call it as a register style function (just a suggestion)
		FuelRegistry.INSTANCE.add(ModItems.COMBUSTILY_BUD, 3200);
	}
}