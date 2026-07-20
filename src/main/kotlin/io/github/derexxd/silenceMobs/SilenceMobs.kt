package io.github.derexxd.silenceMobs

import io.github.derexxd.silenceMobs.listener.SilenceNameTagListener
import org.bukkit.plugin.java.JavaPlugin

class SilenceMobs : JavaPlugin() {

    private lateinit var silenceService: SilenceService

    override fun onEnable() {
        silenceService = SilenceService(this)
        server.pluginManager.registerEvents(SilenceNameTagListener(silenceService), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
