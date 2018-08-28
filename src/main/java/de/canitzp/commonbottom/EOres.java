package de.canitzp.commonbottom;

import java.util.Locale;

/**
 * @author canitzp
 */
public enum EOres{
    
    ALUMINUM(0xFFFFFFFF, 1.0F, 1);
    
    private int color; // AARRGGBB Hex value
    private float hardness;
    private int toolStrength;
    
    EOres(int color, float hardness, int toolStrength){
        this.color = color;
        this.hardness = hardness;
        this.toolStrength = toolStrength;
    }
    
    public int getColor(){
        return color;
    }
    
    public float getHardness(){
        return hardness;
    }
    
    public int getToolStrength(){
        return toolStrength;
    }
    
    public String getRegistryName(){
        return "ore_" + name().toLowerCase(Locale.ENGLISH);
    }
}
