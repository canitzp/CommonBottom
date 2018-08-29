package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.Registries;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;

/**
 * @author canitzp
 */
public class CommonBottom implements IMod{
    
    public static CommonBottom INSTANCE;
    
    public CommonBottom(){
        INSTANCE = this;
    }
    
    @Override
    public String getDisplayName(){
        return "Common Bottom";
    }
    
    @Override
    public String getId(){
        return "commonbottom";
    }
    
    @Override
    public String getVersion(){
        return "VERSION";
    }
    
    @Override
    public String getResourceLocation(){
        return "assets/commonbottom";
    }
    
    @Override
    public void init(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler){
        Registry.init();
    }
    
    @Override
    public void postInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler){
        Registries.WORLD_GENERATORS.register(new ResourceName(this, "ore_gen"), OreGenWrapper.class);
        Registry.post();
    }
}
