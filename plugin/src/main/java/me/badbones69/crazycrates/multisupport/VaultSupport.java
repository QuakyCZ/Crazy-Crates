package me.badbones69.crazycrates.multisupport;

import me.badbones69.crazycrates.Main;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import net.milkbowl.vault.economy.Economy;

public class VaultSupport {
    private static boolean loaded = false;
    private static Economy economy;
    
    public static void load(Economy economy) {
        loaded = true;
        VaultSupport.economy = economy;
    }
    
    public static boolean isLoaded() { return loaded && economy != null; }
    
    public static Economy getEconomy() { return economy; }

    /**
     * Remove required amount of money from player's balance.
     * @param player
     * @param amount
     * @return true if the transaction succeeded. False if player didn't have that much money or error occurred. 
     */
    public static boolean pay(OfflinePlayer player, double amount) {
        Main.getInstance().getLogger().info("pay");
        if(!loaded || economy == null)
            return false;
        
        EconomyResponse response = economy.withdrawPlayer(player, amount);
        return response.transactionSuccess();
    }

    /**
     * Check if player has amount of money.
     * @param player
     * @param amount
     * @return true if player has required amount of money
     */
    public static boolean has(OfflinePlayer player, double amount) {
        if (!loaded || economy == null || amount == 0)
            return false;
        
        return economy.has(player, amount);
    }
}
