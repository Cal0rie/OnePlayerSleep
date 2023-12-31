package ink.beibeil.testplugin;

import ink.beibeil.testplugin.utils.HexCodeUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

public class ExamplePlugin extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
//    private List<Player> sleepingPlayers;

    @Override
    public void onEnable() {
        // 创建并保存配置文件
        config.addDefault("enter-message-rewrite", false);
        config.addDefault("enabled", true);
        config.addDefault("fall-asleep-time", 60);

        // 一人眠模式
        config.addDefault("one-player-mode", false);

        // 跳过黑夜所需的玩家百分比
        config.addDefault("skip-percent", 50);

        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("睡觉插件启动，Made by Cal0rie!");
    }

    @EventHandler
    // 玩家加入游戏
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        // 修改玩家加入提示
        if (!config.getBoolean("enter-message-rewrite")) return;
        event.setJoinMessage("玩家 " + HexCodeUtils.playerString(event.getPlayer().getName()) + " ，启动!");
    }

    @EventHandler
    public void PlayerBedEnter(PlayerBedEnterEvent event) {
        if (!config.getBoolean("enabled")) return;


        // 轮询判断是否睡着
        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            Bukkit.broadcastMessage("玩家 " + HexCodeUtils.playerString(event.getPlayer().getName()) + " 要睡觉了!");
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            long time = config.getLong("fall-asleep-time");

            // 睡眠到指定时间做判断
            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                @Override
                public void run() {
                    // 若未开启一人眠模式
                    if (!config.getBoolean("one-player-mode")) {
                        // 床所在世界玩家
                        List<Player> players = event.getBed().getWorld().getPlayers();

                        int percent = config.getInt("skip-percent");
                        int sleepPlayerCount = 0;
                        for (Player player : players) {
                            // 如果该玩家在bed上，就认为该玩家正在睡觉
                            try {
                                if (!player.getBedLocation().getBlock().isEmpty()) {
                                    sleepPlayerCount++;
                                }
                            } catch (Exception e) {
//                                getLogger().info(e.getMessage());
                            }
                        }

                        if (sleepPlayerCount >= players.size() * percent / 100.0) {
                            String s = "&b天要亮啦~";
                            Bukkit.broadcastMessage(HexCodeUtils.stringWithColor(s));
                            event.getBed().getWorld().setTime(100L);
                        }

                        // 若开启一人眠模式
                    } else {
                        try {
                            event.getPlayer().getBedLocation();
                            String s = "玩家 " + HexCodeUtils.playerString(event.getPlayer().getName()) + " 睡着了，天要亮啦~";
                            Bukkit.broadcastMessage(HexCodeUtils.stringWithColor(s));
                            event.getBed().getWorld().setTime(100L);
                        } catch (Exception ignored) {
                        }
                    }

                }
            }, time);

        }
    }

    ;

    @EventHandler
    public void PlayerBedLeave(PlayerBedEnterEvent event) {
        // 将该玩家移出 sleepingPlayers
//        this.sleepingPlayers.remove(event.getPlayer());
    }
}
