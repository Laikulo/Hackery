package guru.haun.hackery.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GlitchPlacer implements IWorldGenerator {
	
	public void generate(Random rng, int cX, int cZ, World world, IChunkProvider chunkgen, IChunkProvider chunkprov) {
		//Overworld ONLY!!
		if(!world.provider.isSurfaceWorld() ) return;
		//Rarity Set
		if(rng.nextInt(100) != 0) return;
		
		int originX = cX << 4 + rng.nextInt(16);
		int originZ = cZ << 4 + rng.nextInt(16);
		int originY = rng.NextInt(47) + 3;
	}

}
