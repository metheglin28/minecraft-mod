package com.metheglin.tweaks;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetheglinsTweaks implements ModInitializer {
	public static final String MOD_ID = "metheglins_tweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RemovedItems.init();
		LOGGER.info("Metheglin's Tweaks loaded: enchanting table and end portal frame removed, Nether and End disabled.");
	}
}
