package io.shaded.rsocket

import org.bukkit.plugin.java.JavaPlugin

class RSocketSpigotTest : JavaPlugin() {

    override fun onEnable() {
        this.logger.info("Starting RSocket test.")
    }

}