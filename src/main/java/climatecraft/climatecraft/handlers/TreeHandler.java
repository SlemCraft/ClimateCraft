package climatecraft.climatecraft.handlers;

import climatecraft.climatecraft.ClimateCraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

public class TreeHandler implements Listener {
    private int pollutionScore = 0;
    public TreeHandler(ClimateCraft plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTreeGrow(StructureGrowEvent event) {
        Block block = (Block) event.getBlocks();

        if (block.getType() == Material.OAK_SAPLING) {
            pollutionScore = pollutionScore - 1;
        }
    }

    public int getPollutionScore() {
        return pollutionScore;
    }

}
