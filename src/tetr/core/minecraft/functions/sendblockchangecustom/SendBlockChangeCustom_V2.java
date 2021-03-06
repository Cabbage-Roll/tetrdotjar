package tetr.core.minecraft.functions.sendblockchangecustom;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import tetr.core.minecraft.Blocks;
import tetr.core.minecraft.Main;

public class SendBlockChangeCustom_V2 {
    
    //used after 1.13
    
    public static void sendBlockChangeCustom(Player player, Location loc, int color) {
        ItemStack blocks[] = Main.skinmap.get(player);
        
        if(Main.skineditorver.get(player)==1) {
            player.sendBlockChange(loc, blocks[color].getType().createBlockData());
        }else if(Main.skineditorver.get(player)==0) {
            player.sendBlockChange(loc, Blocks.blocks[color].getType().createBlockData());
        }
    }
    
    public static void sendBlockChangeCustom(Player player, Location loc, Block block) {
        player.sendBlockChange(loc, block.getBlockData());
    }
    
}
