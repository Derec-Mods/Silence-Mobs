package io.github.derexxd.silenceMobs.listener

import io.papermc.paper.event.player.PlayerNameEntityEvent
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class SilenceNameTagListener : Listener {

    @EventHandler(ignoreCancelled = true)
    fun onNameEntity(event: PlayerNameEntityEvent) {
        val tagName = PlainTextComponentSerializer.plainText().serialize(event.name ?: return)
        if (!tagName.equals(SILENCE_TAG, ignoreCase = true)) return

        event.isCancelled = true

        event.entity.isSilent = !event.entity.isSilent
        consumeNameTag(event)
    }

    private fun consumeNameTag(event: PlayerNameEntityEvent) {
        if (event.player.gameMode == GameMode.CREATIVE) return

        val item = event.player.inventory.getItem(event.hand) ?: return
        if (item.type != Material.NAME_TAG) return

        item.amount = item.amount - 1
    }

    companion object {
        private const val SILENCE_TAG = "silence"
    }
}
