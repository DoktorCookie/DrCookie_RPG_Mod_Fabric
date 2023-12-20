package net.drcookie.drcookies_rpg_mod;

import net.drcookie.drcookies_rpg_mod.item.ModItemGroups;
import net.drcookie.drcookies_rpg_mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrCookiesRPGMod implements ModInitializer {

	public static final String MOD_ID = "drcookies_rpg_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}