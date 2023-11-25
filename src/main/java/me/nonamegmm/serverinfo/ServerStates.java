package me.nonamegmm.serverinfo;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStates extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("███████╗███████╗██████╗ ██╗   ██╗███████╗██████╗ ██╗███╗   ██╗███████╗ ██████╗");
        console.sendMessage("██╔════╝██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗██║████╗  ██║██╔════╝██╔═══██╗");
        console.sendMessage("███████╗█████╗  ██████╔╝██║   ██║█████╗  ██████╔╝██║██╔██╗ ██║█████╗  ██║   ██║");
        console.sendMessage("╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══╝  ██╔══██╗██║██║╚██╗██║██╔══╝  ██║   ██║");
        console.sendMessage("███████║███████╗██║  ██║ ╚████╔╝ ███████╗██║  ██║██║██║ ╚████║██║     ╚██████╔╝");
        console.sendMessage("╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝");
        console.sendMessage("欢迎使用本插件！");
        console.sendMessage("作者：NoNameGMM");
        console.sendMessage("作者Github地址：https://github.com/NoNameGMM/");
        int pluginId = 1234; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Optional: Add custom charts
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
    }

    @Override
    public void onDisable() {

    }
}
