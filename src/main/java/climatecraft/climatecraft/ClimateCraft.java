package climatecraft.climatecraft;


import climatecraft.climatecraft.commands.OpenScoreboardCommand;
import climatecraft.climatecraft.handlers.TreeHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClimateCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        TreeHandler treeHandler = new TreeHandler(this);

        PluginCommand command = getCommand("sb");
        if (command != null) {
            command.setExecutor(new OpenScoreboardCommand(treeHandler));
        }

        Bukkit.getLogger().info("Hello World");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down");
    }
}

