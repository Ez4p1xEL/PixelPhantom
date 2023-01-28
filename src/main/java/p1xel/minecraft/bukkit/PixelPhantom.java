package p1xel.minecraft.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import p1xel.minecraft.bukkit.Command.Cmd;
import p1xel.minecraft.bukkit.Listeners.AntiSpawn;
import p1xel.minecraft.bukkit.Storage.Locale;

public class PixelPhantom extends JavaPlugin {

    private static PixelPhantom instance;
    public static PixelPhantom getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Locale.createFile();

        getServer().getPluginManager().registerEvents(new AntiSpawn(), this);
        getServer().getPluginCommand("PixelPhantom").setExecutor(new Cmd());
        getLogger().info("Plugin loaded! Thanks for the using!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin unloaded!");
    }

}
