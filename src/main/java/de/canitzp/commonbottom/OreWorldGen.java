package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.Registries;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;
import de.ellpeck.rockbottom.api.world.gen.WorldGenOre;

public class OreWorldGen extends WorldGenOre{
    
    private EOres ore;
    private int usages;
    
    public OreWorldGen(EOres ore, int usages){
        this.ore = ore;
        this.usages = usages;
    }
    
    @Override
    protected int getHighestGridPos(){
        return this.ore.getGetHighestY();
    }
    
    @Override
    protected int getMaxAmount(){
        return this.ore.getGetMaxDefaultAmount() + this.usages - 1;
    }
    
    @Override
    protected int getClusterRadiusX(){
        return Math.min(10, Math.round(this.getMaxAmount() / 3.0F));
    }
    
    @Override
    protected int getClusterRadiusY(){
        return Math.min(10, getClusterRadiusX() * 2);
    }
    
    @Override
    protected TileState getOreState(){
        return Registries.TILE_REGISTRY.get(new ResourceName(CommonBottom.INSTANCE, this.ore.getRegistryName())).getDefState();
    }
    
    @Override
    public int getPriority(){
        return 0;
    }
}
