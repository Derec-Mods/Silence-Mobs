package io.github.derexxd.silenceMobs

import io.github.derexxd.silenceMobs.listener.SilenceNameTagListener
import org.bukkit.plugin.java.JavaPlugin

class SilenceMobs : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(SilenceNameTagListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
