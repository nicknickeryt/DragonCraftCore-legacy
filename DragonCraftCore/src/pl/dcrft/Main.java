package pl.dcrft;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import pl.dcrft.wyjscie.Output;

public class Main extends JavaPlugin implements Listener{
	 
	public static Main plugin;
	   
    
    
    private Map<String, Object> filtry;

    public Main() {

        this.filtry = new HashMap<String, Object>();
    
    }
    public void CheckConfig() {
		 
        if(getConfig().get("pomoc") == null){ 
            getConfig().set("pomoc", "brak"); 
            saveConfig();
            reloadConfig();
 
        }
    }
    public void onEnable() {
         Bukkit.getPluginManager().registerEvents(this, this);   
    	 File file = new File(getDataFolder() + File.separator + "config.yml"); 
       	 
       	 
         if (!file.exists()){
         saveDefaultConfig();
         } else {
         CheckConfig();
         saveConfig();
         reloadConfig();

     }   
    	
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.filtry = (Map<String, Object>)this.getConfig().getConfigurationSection("filtry").getValues(true);
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this);
        Output.print(ChatColor.GREEN + "[" + this.getDescription().getName() + "] v" + this.getDescription().getVersion() + " włączony");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
				Random rand = new Random();
		        String randomElement = getConfig().getStringList("wiadomosci").get(rand.nextInt(getConfig().getStringList("wiadomosci").size()));
		        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("przedrostekwiadomosci")) + ChatColor.translateAlternateColorCodes('&', randomElement));
		        
            }
        }, 20, Integer.parseInt(getConfig().getString("cooldown")) * 20);
    }
    
    public void onDisable() {
    	Output.print(ChatColor.RED + "[" + this.getDescription().getName() + "] v" + this.getDescription().getVersion() + " wyłączony");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
    			if (cmd.getName().equalsIgnoreCase("pomoc")) {
    				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("przedrostek")));
    				for(String msg : getConfig().getStringList("pomoc")) {
    					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    				}
    				return true;
    			}
    			
    			if (cmd.getName().equalsIgnoreCase("vip")) {
    				if (sender.hasPermission("essentials.kits.vip")) {
    					Player p = (Player)sender;
    					p.chat("/warp vip");
    					return true;
    				}
    				else {
                	for(String msg : getConfig().getStringList("vip")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                	}
                        return true;
                    }
        	}
    			if (cmd.getName().equalsIgnoreCase("svip")) {
    				if (sender.hasPermission("essentials.kits.svip")) {
    					Player p = (Player)sender;
    					p.chat("/warp svip");
    					return true;
    				}
    				else {
                	for(String msg : getConfig().getStringList("svip")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                	}
                        return true;
    			}
        	}
    			if (cmd.getName().equalsIgnoreCase("mvip")) {
    				if (sender.hasPermission("essentials.kits.mvip")) {
    					Player p = (Player)sender;
    					p.chat("/warp mvip");
    					return true;
    				}
    				else {
                	for(String msg : getConfig().getStringList("mvip")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                	}
                        return true;
                    }

        	}
    			if (cmd.getName().equalsIgnoreCase("evip")) {
    				if (sender.hasPermission("essentials.kits.evip")) {
    					Player p = (Player)sender;
    					p.chat("/warp evip");
    					return true;
    				}
    				else {
                	for(String msg : getConfig().getStringList("evip")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                	}
                        return true;
                    }
        	}
            	if (cmd.getName().equalsIgnoreCase("cc")){
            		if (sender.hasPermission("cc.adm")) {
            		for(int i = 0; i < 100; ++i) {
            			Bukkit.getServer().broadcastMessage("");
            			
            		}
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("cc")));
            		return true;
            	}
            		
            		else if (!sender.hasPermission("cc.adm")) {
            			sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		}
            		return true;
            	}
            	 if (cmd.getName().equalsIgnoreCase("dcccast")) {
             		if (args.length != 0) {
             			if (sender.hasPermission("dcc.adm")) {
             			StringBuilder sb = new StringBuilder();
             			for (int i = 0; i < args.length; i++){
             			sb.append(args[i]).append(" ");
             			}
             			 
             			String allArgs = sb.toString().trim();
             			Bukkit.getServer().broadcastMessage("§e§lDragon§6§lCraft §e» " + ChatColor.translateAlternateColorCodes('&', allArgs));
             			return true;
             		}
             			else if (!sender.hasPermission("cc.adm")) {
                			sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
                		}
                		return true;
             		}
             			}
             		
             		
             	
            if (cmd.getName().equalsIgnoreCase("dcc")) {
    		if (args.length == 0) {
    			if (sender.hasPermission("dcc.adm")) {
                	sender.sendMessage("§e§lDragon§6§lCraft§a§lCore");
                	sender.sendMessage("§e» §6/pomoc§3 - wyświetla pomoc");
                	sender.sendMessage("§e» §6/dcc przeładuj§3 - przeładowuje config");
                	sender.sendMessage("§e» §6/cc§3 - czyści czat");
                	sender.sendMessage("§e» §6/losuj§3 - losuje");
                	sender.sendMessage("§e» §6/reload60§3 - przeładowuje serwer za minutę");
                	sender.sendMessage("§e» §6/restart60§3 - restartuje serwer za minutę");
                	sender.sendMessage("§e» §6/stop60§3 - zatrzymuje serwer za minutę");
                	sender.sendMessage("§e» §6/przerwa60§3 - rozpoczyna przerwę techniczną za minutę  ");
                	return true;
                	}
    			else {
    				sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
    			}
            	return true;
    		}
        	final String sub = args[0];
        	if (sub.equalsIgnoreCase("przeladuj")) {
        		if (sender.hasPermission("dcc.adm")) {
                	reloadConfig();
                	sender.sendMessage("§e§lDragon§6§lCraft §e» §aPrzeładowano plik konfiguracyjny §e§lDragon§6§lCraft§a§lCore§a.");
                	this.filtry = (Map<String, Object>)this.getConfig().getConfigurationSection("filtry").getValues(true);
                	return true;
        		}
                else {
                		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
                		return true;
                	}
        	}
        		else {
        			sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
        			return true;
        		}
        	}
            if (cmd.getName().equalsIgnoreCase("losuj")) {
        		if (args.length == 0) {
        			if (sender.hasPermission("panel.adm")) {
        				    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("losuje")));
        					Random rand = new Random();
        			        String randomElement = getConfig().getStringList("kolorki").get(rand.nextInt(getConfig().getStringList("kolorki").size()));
        			        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("wylosowano")) + ChatColor.translateAlternateColorCodes('&', randomElement));
        			        return true;
                        
                    	}
        			else {
        				sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
        			}
                	return true;
        		}
            }   	
            if (cmd.getName().equalsIgnoreCase("stop60")) {
            if (sender.hasPermission("r.adm")) {
        		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 minutę serwer zostanie zatrzymany."));
            	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
            	public void run(){
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 30 sekund serwer zostanie zatrzymany."));
                	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
            		}
            		},600);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 15 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},900);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 10 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1000);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 9 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1020);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 8 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1040);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 7 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1060);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 6 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1080);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 5 sekund serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1100);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 4 sekundy serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1120);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 3 sekundy serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1140);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 2 sekundy serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1160);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 sekundę serwer zostanie zatrzymany."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1180);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZapisywanie plików świata.."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1200);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cTrwa zatrzymywanie serwera..."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},1260);
            	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "stop");
                		}
                		},1280);
        		
                return true;
                
                }
        	
        	else {
        		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
        		return true;
        	}
    }
            if (cmd.getName().equalsIgnoreCase("reload60")) {
                if (sender.hasPermission("r.adm")) {
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 minutę odbędzie się ponowne załadowanie plików serwera."));
                	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 30 sekund odbędzie się ponowne załadowanie plików serwera."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},600);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 15 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},900);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 10 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1000);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 9 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1020);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 8 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1040);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 7 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1060);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 6 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1080);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 5 sekund odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1100);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 4 sekundy odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1120);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 3 sekundy odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1140);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 2 sekundy odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1160);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 sekundę odbędzie się ponowne załadowanie plików serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1180);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZapisywanie plików świata..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1200);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cTrwa ponowne ładowanie plików serwera..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1260);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "reload confirm");
                    		}
                    		},1280);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &aPrzeładowano pliki serwera."));
                    		}
                    		},1281);
            		
                    return true;
            	
                    }
            	
            	else {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
        }
            if (cmd.getName().equalsIgnoreCase("restart60")) {
                if (sender.hasPermission("r.adm")) {
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 minutę odbędzie się restart serwera."));
                	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 30 sekund odbędzie się restart serwera."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},600);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 15 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},900);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 10 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1000);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 9 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1020);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 8 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1040);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 7 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1060);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 6 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1080);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 5 sekund odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1100);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 4 sekundy odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1120);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 3 sekundy odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1140);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 2 sekundy odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1160);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 sekundę odbędzie się restart serwera."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1180);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZapisywanie plików świata..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1200);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cTrwa restart serwera..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1260);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "restart");
                    		}
                    		},1280);
            		
                    return true;
            	
                    }
            	
            	else {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
                
        }
            if (cmd.getName().equalsIgnoreCase("przerwa60")) {
                if (sender.hasPermission("r.adm")) {
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 minutę odbędzie się przerwa techniczna."));
                	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                	public void run(){
                		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 30 sekund odbędzie się przerwa techniczna."));
                    	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                		}
                		},600);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 15 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},900);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 10 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1000);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 9 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1020);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 8 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1040);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 7 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1060);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 6 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1080);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 5 sekund odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1100);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 4 sekundy odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1120);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 3 sekundy odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1140);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 2 sekundy odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1160);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZa 1 sekundę odbędzie się przerwa techniczna."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1180);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cZapisywanie plików świata..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1200);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cTrwa przerwa techniczna..."));
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                    		}
                    		},1260);
                	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
                    	public void run(){
                    		Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
                        	Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "whitelist on");
                        	for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                if (!p.isOp() && !p.isWhitelisted()) {
                                    p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&e&lDragon&6&lCraft &e» &cTrwa przerwa techniczna..."));
                                }
                            }
                    		}
                    		},1280);
                    return true;
            	
                    }
            	
            	else {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
                
        }
            if (cmd.getName().equalsIgnoreCase("sklepbroadcast")) {
            	if(!sender.hasPermission("r.adm")) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	if (args.length == 0) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	if (args.length == 1) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("sklep")));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &3Gracz &b" + args[0] + "&3 zakupił &b" + args[1] + "&3!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &3Dziękujemy za wsparcie!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &6Smocze jaja&b dostępne już od &61.23zł&b!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &bSprawdź ofertę na &6DCRFT.PL"));
            	for (Player player : Bukkit.getOnlinePlayers())
            	{
            		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 8.0F);
            	}
            	return true;
    	}
            if (cmd.getName().equalsIgnoreCase("sklepbroadcastdonate")) {
            	if(!sender.hasPermission("r.adm")) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	if (args.length == 0) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	if (args.length == 1) {
            		sender.sendMessage("§e§lDragon§6§lCraft §e» §cNie ma takiej komendy. Użyj §e/info§c, aby dowiedzieć się więcej o dostępnych komendach.");
            		return true;
            	}
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("sklep")));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &3Gracz &b" + args[0] + "&3 wpłacił &b" + args[1] + " &3na rozwój serwera!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &3Dziękujemy za wsparcie!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &6Smocze jaja&b dostępne już od &61.23zł&b!"));
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e» &bSprawdź ofertę na &6DCRFT.PL"));
            	for (Player player : Bukkit.getOnlinePlayers())
            	{
            		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 8.0F);
            	}
            	return true;
    	}
			return false;
    }
    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }
    

    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent w) {
    	Player p = w.getPlayer();
    	boolean grupa = isPlayerInGroup(p, getConfig().getString("czerwonyczat"));
    	if (grupa == true) {
    		String wiadomosc = w.getMessage();
    		w.setMessage("§c" + wiadomosc);
    	}
        String message = w.getMessage().toLowerCase();
        for (final Map.Entry<String, Object> filter : this.filtry.entrySet()) {
            message = message.replaceAll(filter.getKey(), filter.getValue().toString());
        }
        w.setMessage(message);
        if (w.getMessage().length() == 0) {
            w.setCancelled(true);
        }
    }
}
