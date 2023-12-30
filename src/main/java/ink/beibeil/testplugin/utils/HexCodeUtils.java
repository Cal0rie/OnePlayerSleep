package ink.beibeil.testplugin.utils;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexCodeUtils {
    public static String translateHexCodes(String startTag, String endTag, String message) {
        Pattern hexPattern = Pattern.compile(String.valueOf(startTag) + "([A-Fa-f0-9]{6})" + endTag);
        return translate(hexPattern, message);
    }

    private static String translate(Pattern hex, String message) {
        Matcher matcher = hex.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 32);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer,
                    "§x§" + group.charAt(0) + "§" + group.charAt(1) + "§" + group.charAt(2)
                            + "§" + group.charAt(3) + "§" + group.charAt(4) + "§" + group.charAt(5));
        }
        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
    }

    public static String stringWithColor(String message) {
        return translateHexCodes("&#", "", message).replace("&", "§");
    }

    public static String playerString(String message) {
        return stringWithColor("&a" + message + "&#ffffff");
    }
}
