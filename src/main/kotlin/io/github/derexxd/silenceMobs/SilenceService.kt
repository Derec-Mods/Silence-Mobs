package io.github.derexxd.silenceMobs

import org.bukkit.NamespacedKey
import org.bukkit.entity.LivingEntity
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class SilenceService(plugin: JavaPlugin) {

    private val silencedKey = NamespacedKey(plugin, "silenced")

    fun isSilenced(entity: LivingEntity): Boolean =
        entity.persistentDataContainer.has(silencedKey, PersistentDataType.BYTE)

    fun toggle(entity: LivingEntity): Boolean {
        val silenced = !isSilenced(entity)
        entity.isSilent = silenced
        if (silenced) {
            entity.persistentDataContainer.set(silencedKey, PersistentDataType.BYTE, 1)
        } else {
            entity.persistentDataContainer.remove(silencedKey)
        }
        return silenced
    }
}
