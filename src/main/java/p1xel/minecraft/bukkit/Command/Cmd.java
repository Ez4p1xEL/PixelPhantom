package p1xel.minecraft.bukkit.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import p1xel.minecraft.bukkit.PixelPhantom;
import p1xel.minecraft.bukkit.Storage.Config;
import p1xel.minecraft.bukkit.Storage.Locale;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Cmd implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("pixelphantom.admin")) {
            sender.sendMessage(Locale.getMessage("no-perm"));
            return true;
        }

        if (args.length == 0) {
            for (String m : Locale.get().getStringList("commands.main")) {
                sender.sendMessage(Locale.translate(m));
            }
            return true;
        }

        if (args.length == 1) {

            if (args[0].equalsIgnoreCase("help")) {
                for (String m : Locale.get().getStringList("commands.help")) {
                    sender.sendMessage(Locale.translate(m));
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                PixelPhantom.getInstance().reloadConfig();
                sender.sendMessage(Locale.getMessage("reload-success"));
                return true;
            }

            if (args[0].equalsIgnoreCase("clear")) {
                PixelPhantom.getInstance().getConfig().set("blacklist-worlds.worlds", null);
                PixelPhantom.getInstance().saveConfig();
                sender.sendMessage(Locale.getMessage("clear-success"));
                return true;
            }

        }

        if (args.length == 2) {

            if (args[0].equalsIgnoreCase("add")) {

                if (Config.getStringList("blacklist-worlds.worlds").contains(args[1])) {
                    sender.sendMessage(Locale.getMessage("world-exists"));
                    return true;
                }

                List<String> list = Config.getStringList("blacklist-worlds.worlds");
                list.add(args[1]);
                PixelPhantom.getInstance().getConfig().set("blacklist-worlds.worlds", list);
                PixelPhantom.getInstance().saveConfig();
                sender.sendMessage(Locale.getMessage("add-success").replaceAll("%world%", args[1]));
                return true;

            }

            if (args[0].equalsIgnoreCase("remove")) {

                if (!Config.getStringList("blacklist-worlds.worlds").contains(args[1])) {
                    sender.sendMessage(Locale.getMessage("world-does-not-exist"));
                    return true;
                }

                List<String> list = Config.getStringList("blacklist-worlds.worlds");
                list.remove(args[1]);
                PixelPhantom.getInstance().getConfig().set("blacklist-worlds.worlds", list);
                PixelPhantom.getInstance().saveConfig();
                sender.sendMessage(Locale.getMessage("remove-success").replaceAll("%world%", args[1]));
                return true;

            }

        }





        return false;
    }

}
