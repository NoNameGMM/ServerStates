package me.nonamegmm.serverstates;

import org.bukkit.Bukkit;

import java.lang.reflect.Method;

public class Calculator {
    private static Class<?> getNMSClass(String classname) throws ClassNotFoundException {
        String newclassname = "net.minecraft.server." + classname;
        try {
            return Class.forName(newclassname);
        }
        catch (Exception e){
            newclassname = Bukkit.getServer().getClass().getName()
                    .replace("org.bukkit.craftbukkit","net.minecraft.server")
                    .replace("CraftServer",classname);
            try {
                return Class.forName(newclassname);
            }
            catch (Exception ee) {
                return null;
            }
        }
    }

    public static double getTPS(int times) {
        try{
            Class<?> clazz = getNMSClass("MinecraftServer");
            Object mcserver = null;
            {
                Method method = clazz.getMethod("getServer");
                mcserver = method.invoke(null);
            }
            double[] a = (double[]) clazz.getDeclaredField("recentTps").get(mcserver);
            return a[times];
        }
        catch (Exception e) {
            return -1;
        }
    }
    public static double getMSPT(double tps) {
        return 1000 / tps;
    }
}
