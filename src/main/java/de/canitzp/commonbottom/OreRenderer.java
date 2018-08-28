package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.IRenderer;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.assets.texture.ITexture;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.layer.TileLayer;

/**
 * @author canitzp
 */
public class OreRenderer implements ITileRenderer<TileOre>{
    
    private static final ResourceName OVERLAY = new ResourceName(CommonBottom.INSTANCE, "ore_overlay");
    
    private int color;
    
    public OreRenderer(int color){
        this.color = color;
    }
    
    @Override
    public void render(IGameInstance game, IAssetManager manager, IRenderer g, IWorld world, TileOre tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, int[] light){
        //noinspection unchecked
        GameContent.TILE_STONE.getRenderer().render(game, manager, g, world, tile, state, x, y, layer, renderX, renderY, scale, light);
        manager.getTexture(OVERLAY).draw(renderX, renderY, scale, scale, light, this.color);
    }
    
    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, IRenderer g, TileOre tile, ItemInstance instance, float x, float y, float scale, int filter){
        //noinspection unchecked
        GameContent.TILE_STONE.getRenderer().renderItem(game, manager, g, tile, instance, x, y, scale, filter);
        manager.getTexture(OVERLAY).draw(x, y, scale, scale, this.color);
    }
    
    @Override
    public ITexture getParticleTexture(IGameInstance game, IAssetManager manager, IRenderer g, TileOre tile, TileState state){
        //noinspection unchecked
        return GameContent.TILE_STONE.getRenderer().getParticleTexture(game, manager, g, tile, state);
    }
}
