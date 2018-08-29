package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.Registries;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;
import de.ellpeck.rockbottom.api.world.gen.WorldGenOre;

import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class Registry{
    
    private static final Map<EOres, Integer> DEPENDS_MAP = new HashMap<>(); // how much mods do depend on the ore. For WorldGen manipulation
    
    public static void init(){
        for(EOres ore: EOres.values()){
            new TileOre(ore).register();
        }
        
        for(EOres ore : EOres.values()){
            addDependencyForOre(ore.name());
        }
    }
    
    public static void post(){
        for(Map.Entry<EOres, Integer> entry : DEPENDS_MAP.entrySet()){
           OreGenWrapper.subGenerator.add(new OreWorldGen(entry.getKey(), entry.getValue()));
        }
    }
    
    public static void addDependencyForOre(String oreName){
        EOres ore = EOres.getByName(oreName);
        if(ore != null){
            DEPENDS_MAP.put(ore, DEPENDS_MAP.getOrDefault(ore, 0) + 1);
        }else{
            System.out.println("Couldn't create dependency for ore: '" + oreName + "'! (Maybe it doesn't exists)");
        }
    }
    
}
