package climatecraft.climatecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClimateCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Hello World");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down");
    }
}
