package p1xel.minecraft.bukkit.Storage;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import p1xel.minecraft.bukkit.PixelPhantom;

import java.util.List;

public class Config {

    public static String getString(String path) {
        return PixelPhantom.getInstance().getConfig().getString(path);
    }

    public static List<String> getStringList(String path) { return PixelPhantom.getInstance().getConfig().getStringList(path); }

    public static int getInt(String path) {
        return PixelPhantom.getInstance().getConfig().getInt(path);
    }

    public static double getDouble(String path) {
        return PixelPhantom.getInstance().getConfig().getDouble(path);
    }

    public static boolean getBool(String path) {
        return PixelPhantom.getInstance().getConfig().getBoolean(path);
    }

    public static String getVersion() {
        return getString("Version");
    }

    public static String getLanguage() {
        return getString("Language");
    }

    public static FileConfiguration get() {
        return PixelPhantom.getInstance().getConfig();
    }

    public static String getMessage(String path) {
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }
    
}
