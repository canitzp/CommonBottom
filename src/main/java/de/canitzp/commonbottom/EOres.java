package de.canitzp.commonbottom;

import java.util.Locale;

/**
 * @author canitzp
 */
public enum EOres{
    
    ACANTHITE(0xFF2E3238, 1.0F, 1, -1, 3, "Ag2 S"),
    BARYTES(0x80EEEEEE, 1.0F, 1, -1, 4, "Ba S O4"),
    BAUXITE(0xFFB96A46, 0.5F, 1, 0, 4, "Al ( O H )3"),
    BERYL(0x80D0D1C8, 0.75F, 1, -1, 2, "Be3 Al2 ( Si O3 )6"),
    BORNITE(0xFF7F6940, 0.75F, 1, -1, 2, "Cu5 Fe S4"),
    CASSITERITE(0xFF8598A9, 1.0F, 1, -1, 2, "Sn O2"),
    CHALCOCITE(0xFFA7AFB1, 0.75F, 1, -1, 2, "Cu2 S"),
    CHALCOPYRITE(0xFFDED086, 1.0F, 1, 0, 2, "Cu Fe S2"),
    CHROMITE(0xFFF7F9F8, 1.0F, 1, -1, 2, "( Fe , Mg ) Cr2 O4");
    
    private int color; // AARRGGBB Hex value
    private float hardness;
    private int toolStrength;
    private int genHighestY;
    private int genMaxDefaultAmount;
    private String formula;
    
    EOres(int color, float hardness, int toolStrength, int highestGritPosition, int genMaxDefaultAmount, String formula){
        this.color = color;
        this.hardness = hardness;
        this.toolStrength = toolStrength;
        this.genHighestY = highestGritPosition;
        this.genMaxDefaultAmount = genMaxDefaultAmount;
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
    
    public int getGetHighestY(){
        return genHighestY;
    }
    
    public int getGetMaxDefaultAmount(){
        return genMaxDefaultAmount;
    }
    
    public String getRegistryName(){
        return "ore_" + name().toLowerCase(Locale.ENGLISH);
    }
    
    public static EOres getByName(String name){
        for(EOres ore : EOres.values()){
            if(ore.name().equalsIgnoreCase(name)){
                return ore;
            }
        }
        return null;
    }
}
