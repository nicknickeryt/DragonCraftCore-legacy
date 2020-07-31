// 
// Decompiled by Procyon v0.5.36
// 

package pl.dcrft.wyjscie;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class Output
{
    private static ConsoleCommandSender ccs;
    
    static {
    	Output.ccs = Bukkit.getConsoleSender();
    }
    
    public static void print(final Object message) {
    	Output.ccs.sendMessage(new StringBuilder().append(message).toString());
    }
}
