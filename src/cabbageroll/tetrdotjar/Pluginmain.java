package cabbageroll.tetrdotjar;

import org.bukkit.plugin.java.JavaPlugin;

import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;

import org.bukkit.event.EventHandler;


public class Pluginmain extends JavaPlugin implements Listener{

    public static ExampleGui testing=new ExampleGui();
    public static Table sp=new Table();
    public static Duel match;
    public static int numberofsongs;
    String[] pathnames;
    String xd;
    static Song[] sarr;
    
    static JavaPlugin plugin;
    @Override
    public void onEnable() {
        plugin=this;
        System.out.println("Plugin started");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(testing, this);
        this.getCommand("sendinput").setExecutor(new Commandinput());
        this.getCommand("startgame").setExecutor(new Startgame());
        this.getCommand("startduel").setExecutor(new Startduel());
        this.getCommand("duelinput").setExecutor(new Duelinput());
        this.getCommand("editpiece").setExecutor(new Editpiece());
        //trash
        File f = new File("plugins\\Tetr");
        numberofsongs=f.listFiles().length;
        pathnames=new String[numberofsongs];
        sarr=new Song[numberofsongs];
        pathnames = f.list();
        for(int i=0;i<numberofsongs;i++){
            xd="plugins\\Tetr\\"+pathnames[i];
            System.out.print(numberofsongs);
            sarr[i]=NBSDecoder.parse(new File(xd));
        }
        
        Table.slist=new Playlist(sarr);
        Table.rsp=new RadioSongPlayer(Table.slist);
        //tend
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("Welcome " + event.getPlayer().getName() + "!");
    }
    
    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent event){
        int itemId = event.getNewSlot();
        ItemStack item = Pluginmain.sp.player.getInventory().getItem(itemId);
        if(item == null){
            return;
        }
        
        String name="invalid";
        
        if(item.hasItemMeta()){
            name=item.getItemMeta().getDisplayName();
            Pluginmain.sp.userInput(name);
            Pluginmain.sp.player.getInventory().setHeldItemSlot(8);
        }

    }
}