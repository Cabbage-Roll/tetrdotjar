package cabbageroll.tetr.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cabbageroll.tetr.Main;
import cabbageroll.tetr.Table;

public class SettingsMenu implements InventoryHolder {
    private Inventory inventory=null;
    public SettingsMenu(Player player){
        Main.lastui.put(player, "settings");
        Inventory inventory=Bukkit.createInventory(this, 54, "Settings");
        ItemStack border=new ItemStack(Material.THIN_GLASS);
        //fill the border with glass
        for(int i=0;i<9;i++){
            inventory.setItem(i, border);
        }
        for(int i=45;i<54;i++){
            inventory.setItem(i, border);
        }
        
        //clickable items
        ItemStack item;
        ItemMeta itemmeta;

        Table table=Main.roommap.get(Main.inwhichroom.get(player)).playerboards.get(player);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("BACK");
        item.setItemMeta(itemmeta);
        inventory.setItem(36, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("your pos");
        item.setItemMeta(itemmeta);
        inventory.setItem(11, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("GX: "+table.gx);
        item.setItemMeta(itemmeta);
        inventory.setItem(12, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("GY: "+table.gy);
        item.setItemMeta(itemmeta);
        inventory.setItem(13, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("GZ: "+table.gz);
        item.setItemMeta(itemmeta);
        inventory.setItem(14, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M1X: "+table.m1x);
        item.setItemMeta(itemmeta);
        inventory.setItem(37, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M2X: "+table.m2x);
        item.setItemMeta(itemmeta);
        inventory.setItem(38, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M3X: "+table.m3x);
        item.setItemMeta(itemmeta);
        inventory.setItem(39, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M1Y: "+table.m1y);
        item.setItemMeta(itemmeta);
        inventory.setItem(41, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M2Y: "+table.m2y);
        item.setItemMeta(itemmeta);
        inventory.setItem(42, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("M3Y: "+table.m3y);
        item.setItemMeta(itemmeta);
        inventory.setItem(43, item);
        
        item=new ItemStack(Material.DIRT);
        player.openInventory(inventory);
    }
    
    @Override
    public Inventory getInventory(){
        return inventory;
    }

}