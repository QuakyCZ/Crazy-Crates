package com.badbones69.crazycrates.api.events;

import com.badbones69.crazycrates.api.objects.Crate;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerReceiveKeyEvent extends Event implements Cancellable {
    
    private static final HandlerList handlers = new HandlerList();
    
    private Player player;
    private Crate crate;
    private KeyReciveReason reason;
    private int amount;
    private boolean isCancelled;
    
    public PlayerReceiveKeyEvent(Player player, Crate crate, KeyReciveReason reason, int amount) {
        this.player = player;
        this.crate = crate;
        this.reason = reason;
        this.amount = amount;
        isCancelled = false;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Crate getCrate() {
        return crate;
    }
    
    public KeyReciveReason getReason() {
        return reason;
    }
    
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }
    
    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = cancel;
    }
    
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public enum KeyReciveReason {
        /**
         * Received a key from the /cc give command.
         */
        GIVE_COMMAND,
        /**
         * Received a key from the /cc giveall command.
         */
        GIVE_ALL_COMMAND,
        /**
         * Received when player has come online after being given a key while offline.
         */
        OFFLINE_PLAYER,
        /**
         * Received a key as a refund from a crate that failed.
         */
        REFUND,
        /**
         * Received a key from the /cc transfer command.
         */
        TRANSFER
    }
    
}
