package cabbageroll.tetr.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cabbageroll.tetr.Main;
import xseries.XMaterial;

public class RoomMenu implements InventoryHolder{
    private Inventory inventory=null;
    public RoomMenu(Player player){
        Main.lastui.put(player, "room");
        Inventory inventory=Bukkit.createInventory(this, 54, "Room - "+Main.inwhichroom.get(player));
        ItemStack border=XMaterial.GLASS_PANE.parseItem();
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
        
        item=XMaterial.PLAYER_HEAD.parseItem();
        int i=0;
        for(Player p: Main.roommap.get(Main.inwhichroom.get(player)).playerlist){
            itemmeta=item.getItemMeta();
            itemmeta.setDisplayName(p.getName());
            if(Main.roommap.get(Main.inwhichroom.get(player)).host.equals(p)){
                itemmeta.setLore(Arrays.asList("HOST"));
            }else{
                itemmeta.setLore(null);
            }

            item.setItemMeta(itemmeta);
            inventory.setItem(9+i, item);
            i++;
        }
        
        if(Main.roommap.get(Main.inwhichroom.get(player)).host.equals(player)){
            if(Main.roommap.get(Main.inwhichroom.get(player)).running){
                item=new ItemStack(Material.ANVIL);
                itemmeta=item.getItemMeta();
                itemmeta.setDisplayName("ABORT");
                item.setItemMeta(itemmeta);
                inventory.setItem(49, item);
            }else{
                item=new ItemStack(Material.DIAMOND_SWORD);
                itemmeta=item.getItemMeta();
                itemmeta.setDisplayName("START");
                item.setItemMeta(itemmeta);
                inventory.setItem(49, item);
            }
        }else{
            item=new ItemStack(Material.BARRIER);
            itemmeta=item.getItemMeta();
            itemmeta.setDisplayName("YOU ARE NOT THE HOST");
        }
        
        item.setItemMeta(itemmeta);
        inventory.setItem(49, item);
        
        item=new ItemStack(Material.DIRT);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("BACK");
        item.setItemMeta(itemmeta);
        inventory.setItem(36, item);
        
        item=new ItemStack(Material.COMPASS);
        itemmeta=item.getItemMeta();
        itemmeta.setDisplayName("Settings!");
        item.setItemMeta(itemmeta);
        inventory.setItem(53, item);
        
        player.openInventory(inventory);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
