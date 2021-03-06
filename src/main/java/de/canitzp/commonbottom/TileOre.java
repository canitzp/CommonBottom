package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ItemTile;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.layer.TileLayer;

import java.util.Collections;
import java.util.List;

/**
 * @author canitzp
 */
public class TileOre extends TileBasic{
    
    private EOres ore;
    private final ITileRenderer<TileOre> customRenderer;
    
    public TileOre(EOres ore){
        super(new ResourceName(CommonBottom.INSTANCE, ore.getRegistryName()));
        this.ore = ore;
        this.setHardness(ore.getHardness());
        this.addEffectiveTool(ToolType.PICKAXE, ore.getToolStrength());
        this.customRenderer = new OreRenderer(this.ore.getColor());
    }
    
    @Override
    public List<ItemInstance> getDrops(IWorld world, int x, int y, TileLayer layer, Entity destroyer){
        return Collections.singletonList(new ItemInstance(this.getItem()));
    }
    
    @Override
    protected ITileRenderer createRenderer(ResourceName name){
        return null;
    }
    
    @Override
    public ITileRenderer getRenderer(){
        return this.customRenderer;
    }
    
    @Override
    protected ItemTile createItemTile(){
        return new ItemTile(this.name){
            @Override
            public String getLocalizedName(ItemInstance instance){
                IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
                return assets.localize(new ResourceName(CommonBottom.INSTANCE, ore.getRegistryName())) + " " + assets.localize(new ResourceName(CommonBottom.INSTANCE, "material.ore"));
            }
        };
    }
}
