package com.badbones69.crazycrates.func.listeners

import com.badbones69.crazycrates.api.CrazyManager
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent

class BasicListener : Listener {

    @EventHandler
    fun onItemPickUp(e: EntityPickupItemEvent): Unit = with(e) {
        if (CrazyManager.getInstance().isDisplayReward(item)) isCancelled = true else {
            if (entity !is Player) return
            val player = entity as Player
            if (CrazyManager.getInstance().isInOpeningList(player)) isCancelled = true
        }
    }
}