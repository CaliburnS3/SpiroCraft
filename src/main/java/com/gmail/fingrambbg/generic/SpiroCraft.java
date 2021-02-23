package com.gmail.fingrambbg.generic;
import org.bukkit.Color;
import org.bukkit.Location;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.*;
import org.bukkit.util.Vector;
import java.util.ArrayList;



public class SpiroCraft extends JavaPlugin implements Runnable{
	static World world;
	Location loc;
	ArrayList<Location> points;
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("spiral")) {
				//TODO
				//draw((Player) sender);
				world = ((Player) sender).getWorld();
				points = new ArrayList<Location>();
				points = Spirograph.drawSeeded(points, ((Player) sender).getLocation());
				
				run();
				return true;
			}
			return true;
		}
		
		sender.sendMessage("Console cannot use /spiral commands, sorry!");
		return true;
	}
	
	public void drawLine(Location point1, Location point2, double space) {
	    double distance = point1.distance(point2);
	    Vector p1 = point1.toVector();
	    Vector p2 = point2.toVector();
	    Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
	    double length = 0;
	    for (; length < distance; p1.add(vector)) {
	    	world.spawnParticle(Particle.FLAME, p1.getX(), p1.getY(), p1.getZ(), 1, 0, 0, 0, 0);
	        length += space;
	    }
	}
	
	public void run(){
		for(int t = 0; t < 10; t++){
			for(int i = 0; i < points.size() - 2; i++){
				drawLine(points.get(i), points.get(i+1), 2);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
