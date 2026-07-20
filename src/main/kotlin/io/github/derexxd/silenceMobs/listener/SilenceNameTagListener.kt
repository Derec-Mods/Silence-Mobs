package io.github.derexxd.silenceMobs.listener

import io.papermc.paper.event.player.PlayerNameEntityEvent
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class SilenceNameTagListener : Listener {

    @EventHandler(ignoreCancelled = true)
    fun onNameEntity(event: PlayerNameEntityEvent) {
        val tagName = PlainTextComponentSerializer.plainText().serialize(event.name ?: return)
        if (!tagName.equals(SILENCE_TAG, ignoreCase = true)) return

        event.isCancelled = true

        event.entity.isSilent = !event.entity.isSilent
        consumeNameTag(event.player)
    }

    private fun consumeNameTag(player: Player) {
        if (player.gameMode == GameMode.CREATIVE) return

        val mainHand = player.inventory.itemInMainHand
        if (mainHand.type == Material.NAME_TAG) {
            mainHand.amount = mainHand.amount - 1
            return
        }

        val offHand = player.inventory.itemInOffHand
        if (offHand.type == Material.NAME_TAG) {
            offHand.amount = offHand.amount - 1
        }
    }

    companion object {
        private const val SILENCE_TAG = "silence"
    }
}
