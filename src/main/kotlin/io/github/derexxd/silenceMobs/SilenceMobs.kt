package io.github.derexxd.silenceMobs

import io.github.derexxd.silenceMobs.listener.SilenceNameTagListener
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SilenceMobs : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(SilenceNameTagListener(), this)

        this.componentLogger.info(Component.empty())
        this.componentLogger.info(Component.text("  |_______|                             ", NamedTextColor.GREEN))
        this.componentLogger.info(
            Component.text(
                "  | Derex |     Derex Silence Mobs v${description.version}",
                NamedTextColor.GREEN
            )
        )
        this.componentLogger.info(
            Component.text(
                "  |_______|     Running on ${Bukkit.getName()} - ${Bukkit.getVersion()}",
                NamedTextColor.GREEN
            )
        )
        this.componentLogger.info(Component.empty())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
