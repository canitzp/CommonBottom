package de.canitzp.commonbottom;

import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;
import de.ellpeck.rockbottom.api.world.gen.WorldGenOre;

import java.util.ArrayList;
import java.util.List;

public class OreGenWrapper implements IWorldGenerator{
    
    public static final List<IWorldGenerator> subGenerator = new ArrayList<>();
    
    private int currentPrio = 0;
    
    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk){
        return subGenerator.stream().anyMatch(iWorldGenerator -> iWorldGenerator.shouldGenerate(world, chunk));
    }
    
    @Override
    public void generate(IWorld world, IChunk chunk){
        for(IWorldGenerator sub : subGenerator){
            if(sub.shouldGenerate(world, chunk)){
                this.currentPrio = sub.getPriority();
                sub.generate(world, chunk);
            }
        }
    }
    
    @Override
    public int getPriority(){
        return this.currentPrio;
    }
}
