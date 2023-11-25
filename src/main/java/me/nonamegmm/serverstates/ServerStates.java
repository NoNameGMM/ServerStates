package me.nonamegmm.serverstates;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.ConsoleCommandSender;

public final class ServerStates extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("███████╗███████╗██████╗ ██╗   ██╗███████╗██████╗ ███████╗████████╗ █████╗ ████████╗███████╗███████╗");
        console.sendMessage("██╔════╝██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗╚══██╔══╝██╔════╝██╔════╝");
        console.sendMessage("███████╗█████╗  ██████╔╝██║   ██║█████╗  ██████╔╝███████╗   ██║   ███████║   ██║   █████╗  ███████╗");
        console.sendMessage("╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║   ██║   ██╔══██║   ██║   ██╔══╝  ╚════██║");
        console.sendMessage("███████║███████╗██║  ██║ ╚████╔╝ ███████╗██║  ██║███████║   ██║   ██║  ██║   ██║   ███████╗███████║");
        console.sendMessage("╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝   ╚══════╝╚══════╝");
        console.sendMessage("欢迎使用本插件！");
        console.sendMessage("作者：NoNameGMM");
        console.sendMessage("插件Github地址：https://github.com/NoNameGMM/ServerStates");
        int pluginId = 20377;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
