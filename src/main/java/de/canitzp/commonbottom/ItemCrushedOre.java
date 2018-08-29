package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.IRenderer;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.assets.texture.ITexture;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;

import java.util.Locale;

public class ItemCrushedOre extends ItemBasic{
    
    private static ResourceName TEXTURE = new ResourceName(CommonBottom.INSTANCE, "crushed_ore");
    
    private EOres ore;
    private IItemRenderer<ItemCrushedOre> renderer;
    
    public ItemCrushedOre(EOres ore){
        super(new ResourceName(CommonBottom.INSTANCE, "crushed_" + ore.name().toLowerCase(Locale.ENGLISH)));
        this.ore = ore;
        this.renderer = new IItemRenderer<ItemCrushedOre>(){
            @Override
            public void render(IGameInstance game, IAssetManager manager, IRenderer g, ItemCrushedOre item, ItemInstance instance, float x, float y, float scale, int filter){
                manager.getTexture(TEXTURE).draw(x, y, scale, scale, ore.getColor());
            }
    
            @Override
            public ITexture getParticleTexture(IGameInstance game, IAssetManager manager, IRenderer g, ItemCrushedOre item, ItemInstance instance){
                return manager.getTexture(TEXTURE);
            }
        };
    }
    
    @Override
    public IItemRenderer getRenderer(){
        return this.renderer;
    }
    
    @Override
    public String getLocalizedName(ItemInstance instance){
        IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
        return assets.localize(new ResourceName(CommonBottom.INSTANCE, "material.crushed")) +
            " " +
            assets.localize(new ResourceName(CommonBottom.INSTANCE, ore.getRegistryName())) +
            " " +
            assets.localize(new ResourceName(CommonBottom.INSTANCE, "material.ore"));
    }
}
