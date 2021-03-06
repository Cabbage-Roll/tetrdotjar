package tetr.core.minecraft.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.cryptomorin.xseries.XMaterial;

import net.md_5.bungee.api.ChatColor;
import tetr.core.minecraft.Main;

public class HomeMenu implements InventoryHolder {
    private Inventory inventory = null;

    protected final static int MULTIPLAYER_LOCATION = 21;
    protected final static int SINGLEPLAYER_LOCATION = 22;
    protected final static int SKINEDITOR_LOCATION = 23;
    
    public HomeMenu(Player player){
        Main.lastui.put(player, "home");
        Inventory inventory=Bukkit.createInventory(this, 54, "Home");
        ItemStack border=XMaterial.GLASS_PANE.parseItem();
        //fill the border with glass
        for(int i=0;i<9;i++){
            inventory.setItem(i, border);
        }
        for(int i=45;i<54;i++){
            inventory.setItem(i, border);
        }
        
        inventory.setItem(MULTIPLAYER_LOCATION, createItem(XMaterial.PLAYER_HEAD, ChatColor.WHITE + "Multiplayer"));
        inventory.setItem(SINGLEPLAYER_LOCATION, createItem(XMaterial.PLAYER_HEAD, ChatColor.WHITE + "Singleplayer"));
        inventory.setItem(SKINEDITOR_LOCATION, createItem(XMaterial.SHEARS, ChatColor.WHITE + "Skin editor"));
        
        player.openInventory(inventory);
    }
    
    static ItemStack createItem(final XMaterial material, final String name, final String... lore) {
        ItemStack item = material.parseItem();
        ItemMeta meta;
        meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
