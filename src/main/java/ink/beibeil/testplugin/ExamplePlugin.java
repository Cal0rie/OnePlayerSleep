package ink.beibeil.testplugin;

import ink.beibeil.testplugin.utils.HexCodeUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public class ExamplePlugin extends JavaPlugin implements Listener {
//    private List<Player> sleepingPlayers;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("睡觉插件启动，Made by Cal0rie!");
    }

    @EventHandler
    // 玩家加入游戏
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        // 修改玩家加入提示
        event.setJoinMessage("玩家 " + HexCodeUtils.playerString(event.getPlayer().getName()) + " ，启动!");
    }

    @EventHandler
    public void PlayerBedEnter(PlayerBedEnterEvent event) {
        // 判断是否睡着
        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            Bukkit.broadcastMessage("玩家 " + HexCodeUtils.playerString(event.getPlayer().getName()) + " 要睡觉了!");
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                @Override
                public void run() {
                    try {
                        String s = "玩家 &a" + event.getPlayer().getName() + " &#ffffff睡着了! 天要亮啦~";
                        Bukkit.broadcastMessage(HexCodeUtils.stringWithColor(s));

                        event.getPlayer().getBedLocation();
                        event.getBed().getWorld().setTime(100L);
                    } catch (Exception e) {
                        getLogger().info(e.getMessage());
                    }
                }
            }, 60L);

        }
    }

    ;

    @EventHandler
    public void PlayerBedLeave(PlayerBedEnterEvent event) {
        // 将该玩家移出 sleepingPlayers
//        this.sleepingPlayers.remove(event.getPlayer());
    }
}
