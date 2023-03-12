package climatecraft.climatecraft.commands;

import climatecraft.climatecraft.handlers.TreeHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*; // This import is for all contents associated with scoreboard

public class OpenScoreboardCommand implements CommandExecutor {

    private final TreeHandler treeHandler;

    public OpenScoreboardCommand(TreeHandler treeHandler) {
        this.treeHandler = treeHandler;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            // Create Player object (player)
            Player player = (Player) sender;
            // Create ScoreboardManager object (manager)
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            // Create Scoreboard object (scoreboard)
            Scoreboard scoreboard = manager.getNewScoreboard();

            // Create Objective object (objective) and set scoreboard type + name
            Objective objective = scoreboard.registerNewObjective("Pollution_score", "dummy");
            // Set scoreboard location on screen
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            // Set scoreboard title
            objective.setDisplayName(ChatColor.RED + "Pollution Score");

            // Create scoreboard contents
            Score s0 = objective.getScore(""); //blank space
            Score s1 = objective.getScore(ChatColor.YELLOW + "Pollution: " + ChatColor.DARK_RED + treeHandler.getPollutionScore()); // Pollution counter display
            Score s2 = objective.getScore(""); //blank space
            Score s3 = objective.getScore(ChatColor.AQUA + "Ichthuslyceum"); // Display of Ichthuslyceum

            // Set on witch line the contents of the scoreboard has to be (1 = the lowest line)
            s0.setScore(4);
            s1.setScore(3);
            s2.setScore(2);
            s3.setScore(1);

            // Set scoreboard for the player
            player.setScoreboard(scoreboard);

        }






        return true;
    }

}
