package de.canitzp.commonbottom;

import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class Registry{
    
    private static final Map<EOres, Integer> DEPENDS_MAP = new HashMap<>();
    
    public static void init(){
        for(EOres ore: EOres.values()){
            new TileOre(ore).register();
        }
    }
    
    public static void addDependencyForOre(String oreName){
        try{
            EOres ore = EOres.valueOf(oreName);
            DEPENDS_MAP.put(ore, DEPENDS_MAP.getOrDefault(ore, 0) + 1);
        } catch(IllegalArgumentException e){
            System.out.println("Couldn't create dependency for ore: '" + oreName + "'! (Maybe it doesn't exists)");
        }
    }
    
}
