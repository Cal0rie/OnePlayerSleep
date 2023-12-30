package ink.beibeil.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class BedTask extends BukkitRunnable {
    @Override
    public void run() {
        World world = Bukkit.getWorld("world");
//        if(world.getTime() >= 24000){
//            this.cancel();
//            return;
//        }
        if (world != null) {
            world.setTime(100);
        }
    }
}