package me.nonamegmm.serverstates;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.ConsoleCommandSender;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ServerStates extends JavaPlugin implements CommandExecutor {
    String[] languages = {"Chinese","English"};
    String MaxMemory,TotalMemory,UsedMemory,MemoryUsage,FreeMemory,HeapUsage,NonHeapUsage,Wrong,PlayerAmount,ServerRunTime,Day,Hour,Minute,Second,TPSMessage
    ,TPS1s,TPS5s,TPS15s,MSPTMessage,MSPT1s,MSPT5s,MSPT15s,language,ReloadSuccess,Help,MemoryOptimize,ChunkUnit,ChunkAll,ChunkCleared;
    public void CopyFile() {
        for (String language : languages) {
            File dataFolder = getDataFolder();
            File languageFolder = new File(dataFolder, "Language");
            languageFolder.mkdirs();
            String sourceFilePath = "Language/" + language + ".yml";
            File destinationFile = new File(languageFolder, language + ".yml");
            File ConfigFile = new File("config.yml");
            String ConfigFilePath = "config.yml";
            if (!destinationFile.exists()) {
                try (InputStream inputStream = getResource(sourceFilePath)) {
                    Files.copy(inputStream, destinationFile.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!ConfigFile.exists()) {
                try (InputStream inputStream = getResource(ConfigFilePath)) {
                    Files.copy(inputStream, ConfigFile.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void getSetting() {
        reloadConfig();
        language = getConfig().getString("Language");
        File languagefile = new File(getDataFolder() + "/Language/" + language + ".yml");
        if (languagefile.exists()) {
            YamlConfiguration lang = YamlConfiguration.loadConfiguration(new File(getDataFolder(),"/Language/" + language + ".yml"));
            MaxMemory = lang.getString("MaxMemory");
            TotalMemory = lang.getString("TotalMemory");
            UsedMemory = lang.getString("UsedMemory");
            MemoryUsage = lang.getString("MemoryUsage");
            FreeMemory = lang.getString("FreeMemory");
            HeapUsage = lang.getString("HeapUsage");
            NonHeapUsage = lang.getString("NonHeapUsage");
            Wrong = lang.getString("Wrong");
            PlayerAmount = lang.getString("PlayerAmount");
            ServerRunTime = lang.getString("ServerRunTime");
            Day = lang.getString("Day");
            Hour = lang.getString("Hour");
            Minute = lang.getString("Minute");
            Second = lang.getString("Second");
            TPSMessage = lang.getString("TPSMessage");
            TPS1s = lang.getString("TPS1s");
            TPS5s = lang.getString("TPS5s");
            TPS15s = lang.getString("TPS15s");
            MSPTMessage = lang.getString("MSPTMessage");
            MSPT1s = lang.getString("MSPT1s");
            MSPT5s = lang.getString("MSPT5s");
            MSPT15s = lang.getString("MSPT15s");
            ReloadSuccess = lang.getString("ReloadSuccess");
            Help = lang.getString("Help");
            MemoryOptimize = lang.getString("MemoryOptimize");
            ChunkUnit = lang.getString("ChunkUnit");
            ChunkAll = lang.getString("ChunkAll");
            ChunkCleared = lang.getString("ChunkCleared");
        }
        else {
            System.out.println("Didn't find your selected language file");
            System.out.println("Using default language file");
            getConfig().set("Language","English");
            saveConfig();
            reloadConfig();
            language = getConfig().getString("Language");
            YamlConfiguration lang = YamlConfiguration.loadConfiguration(new File(getDataFolder(),"/Language/" + language + ".yml"));
            MaxMemory = lang.getString("MaxMemory");
            TotalMemory = lang.getString("TotalMemory");
            UsedMemory = lang.getString("UsedMemory");
            MemoryUsage = lang.getString("MemoryUsage");
            FreeMemory = lang.getString("FreeMemory");
            HeapUsage = lang.getString("HeapUsage");
            NonHeapUsage = lang.getString("NonHeapUsage");
            Wrong = lang.getString("Wrong");
            PlayerAmount = lang.getString("PlayerAmount");
            ServerRunTime = lang.getString("ServerRunTime");
            Day = lang.getString("Day");
            Hour = lang.getString("Hour");
            Minute = lang.getString("Minute");
            Second = lang.getString("Second");
            TPSMessage = lang.getString("TPSMessage");
            TPS1s = lang.getString("TPS1s");
            TPS5s = lang.getString("TPS5s");
            TPS15s = lang.getString("TPS15s");
            MSPTMessage = lang.getString("MSPTMessage");
            MSPT1s = lang.getString("MSPT1s");
            MSPT5s = lang.getString("MSPT5s");
            MSPT15s = lang.getString("MSPT15s");
            ReloadSuccess = lang.getString("ReloadSuccess");
            Help = lang.getString("Help");
            MemoryOptimize = lang.getString("MemoryOptimize");
            ChunkUnit = lang.getString("ChunkUnit");
            ChunkAll = lang.getString("ChunkAll");
            ChunkCleared = lang.getString("ChunkCleared");
        }
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length==1) {
            list.add("memory");
            list.add("runtime");
            list.add("tps");
            list.add("mspt");
            list.add("clean");
            list.add("reload");
            list.add("help");
            return list;
        }
        return null;
    }
    @Override
    public void onEnable() {
        saveDefaultConfig();
        CopyFile();
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("███████╗███████╗██████╗ ██╗   ██╗███████╗██████╗ ███████╗████████╗ █████╗ ████████╗███████╗███████╗");
        console.sendMessage("██╔════╝██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗╚══██╔══╝██╔════╝██╔════╝");
        console.sendMessage("███████╗█████╗  ██████╔╝██║   ██║█████╗  ██████╔╝███████╗   ██║   ███████║   ██║   █████╗  ███████╗");
        console.sendMessage("╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║   ██║   ██╔══██║   ██║   ██╔══╝  ╚════██║");
        console.sendMessage("███████║███████╗██║  ██║ ╚████╔╝ ███████╗██║  ██║███████║   ██║   ██║  ██║   ██║   ███████╗███████║");
        console.sendMessage("╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝   ╚══════╝╚══════╝");
        console.sendMessage("欢迎使用本插件！Welcome to use this plugin");
        console.sendMessage("服务器版本/Server Version: " + Bukkit.getServer().getVersion());
        console.sendMessage("作者/Author: NoNameGMM");
        console.sendMessage("插件Github地址/Github Address: https://github.com/NoNameGMM/ServerStates");
        getSetting();
        int pluginId = 20377;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("memory")) {
            Runtime runtime = Runtime.getRuntime();
            long maxMemory = runtime.maxMemory();
            long totalMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            long usedMemory = totalMemory - freeMemory;

            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
            MemoryUsage nonHeapUsage = memoryMXBean.getNonHeapMemoryUsage();

            sender.sendMessage("------- " + MemoryUsage + "-------");
            sender.sendMessage(MaxMemory + (maxMemory / (1024 * 1024)) + " MB");
            sender.sendMessage(TotalMemory + (totalMemory / (1024 * 1024)) + " MB");
            sender.sendMessage(UsedMemory + (usedMemory / (1024 * 1024)) + " MB");
            sender.sendMessage(FreeMemory + (freeMemory / (1024 * 1024)) + " MB");
            sender.sendMessage(HeapUsage + (heapUsage.getUsed() / (1024 * 1024)) + " MB");
            sender.sendMessage(NonHeapUsage + (nonHeapUsage.getUsed() / (1024 * 1024)) + " MB");
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("player")) {
            int maxPlayers = Bukkit.getServer().getMaxPlayers();
            List<Player> onlinePlayers = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
            sender.sendMessage(PlayerAmount + onlinePlayers.size() + "/" + maxPlayers);
            for (Player onlinePlayer : onlinePlayers) {
                sender.sendMessage(onlinePlayer.getName() + " ");
            }
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("runtime")) {
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            long uptime = runtimeMXBean.getUptime() / 1000;

            long seconds = uptime % 60;
            long minutes = (uptime / 60) % 60;
            long hours = (uptime / 3600) % 24;
            long days = uptime / 86400;

            sender.sendMessage(ChatColor.GREEN + ServerRunTime + days + Day + hours + Hour + minutes + Minute + seconds + Second);
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("tps")){
            int tps1s = (int) Calculator.getTPS(0);
            int tps5s = (int) Calculator.getTPS(1);
            int tps15s = (int) Calculator.getTPS(2);
            sender.sendMessage(TPSMessage);
            sender.sendMessage(TPS1s + tps1s);
            sender.sendMessage(TPS5s + tps5s);
            sender.sendMessage(TPS15s + tps15s);
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("mspt")) {
            int mspt1s = (int) Calculator.getMSPT(Calculator.getTPS(0));
            int mspt5s = (int) Calculator.getMSPT(Calculator.getTPS(1));
            int mspt15s = (int) Calculator.getMSPT(Calculator.getTPS(2));
            sender.sendMessage(MSPTMessage);
            sender.sendMessage(MSPT1s + mspt1s);
            sender.sendMessage(MSPT5s + mspt5s);
            sender.sendMessage(MSPT15s + mspt15s);
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("clean")) {
            int chunkamount = 0,entityamount = 0, cleanedchunk = 0, cleanedentity = 0;
            List<Player> onlinePlayers = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
            List<World> worlds = Bukkit.getWorlds();
            for (World world : worlds) {
                for (Chunk chunk : world.getLoadedChunks()) {
                    chunkamount += 1;
                    if (chunk.isLoaded()) {
                        boolean hasPlayer = false;
                        for (Player player : onlinePlayers) {
                            if (player.getWorld().equals(world) && player.getLocation().getChunk().equals(chunk)) {
                                hasPlayer = true;
                                break;
                            }
                        }
                        if (!hasPlayer) {
                            cleanedchunk += 1;
                          chunk.unload(true);
                        }
                    }
                }
            }
            // 获取所有世界
            for (World world : Bukkit.getWorlds()) {
                Entity[] entities = world.getEntities().toArray(new Entity[0]);
                Random random = new Random();
                for (Entity entity : entities) {
                    if (random.nextBoolean()) {
                        entity.remove();
                        cleanedentity += 1;
                    }
                }
                entityamount += entities.length;
            }
            System.gc();
            sender.sendMessage(ChunkAll + " " + chunkamount + " " + ChunkUnit + "/" + ChunkCleared + " " + cleanedchunk + " " + ChunkUnit);
            sender.sendMessage(MemoryOptimize);
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            getSetting();
            sender.sendMessage(ReloadSuccess);
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("------- " + Help + "-------");
            sender.sendMessage("/serverstates memory");
            sender.sendMessage("/serverstates runtime");
            sender.sendMessage("/serverstates tps");
            sender.sendMessage("/serverstates mspt");
            sender.sendMessage("/serverstates clean");
            sender.sendMessage("/serverstates reload");
            sender.sendMessage("/serverstates help");
        }
        else {
            sender.sendMessage(Wrong);
        }
        return true;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
