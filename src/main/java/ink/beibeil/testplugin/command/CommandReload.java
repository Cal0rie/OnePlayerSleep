package ink.beibeil.testplugin.command;

import ink.beibeil.testplugin.ExamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

import static org.apache.logging.log4j.LogManager.getLogger;

public class CommandReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        getLogger().info("插件配置已重载");
        try {
            if (Objects.equals(args[0], "reload")) {
                ExamplePlugin plugin = ExamplePlugin.getPlugin(ExamplePlugin.class);
                plugin.init();
                sender.sendMessage("[OnePlayerSleep] Plugin reloaded.");
            } else {
                sender.sendMessage("[OnePlayerSleep] There is no such command.");
                return false;
            }
        } catch (Exception e) {
            sender.sendMessage("[OnePlayerSleep] Check the integrity of the command.");
            return false;
        }
        return true;
    }
}
