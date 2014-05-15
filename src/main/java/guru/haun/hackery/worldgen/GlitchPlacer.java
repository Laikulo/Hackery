package guru.haun.hackery.worldgen;

import guru.haun.hackery.HackeryMod;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GlitchPlacer implements IWorldGenerator {
	
	private HackeryMod instance;
	
	public void generate(Random rng, int cX, int cZ, World world, IChunkProvider chunkgen, IChunkProvider chunkprov) {
		//Overworld ONLY!!
		if(!world.provider.isSurfaceWorld() ) return;
		//Rarity Set
		if(rng.nextInt(100) != 0) return;
		
		int originX = cX << 4 + rng.nextInt(16);
		int originZ = cZ << 4 + rng.nextInt(16);
		int originY = rng.nextInt(47) + 3;
		
		int lengthX = rng.nextInt(3) + 3;
		int lengthZ = rng.nextInt(3) + 3;
		int lengthY = rng.nextInt(3) + 6;
		
		int centerX = originX + (lengthX >> 1);
		int centerZ = originZ + (lengthZ >> 1);
		int centerY = originY + (lengthY >> 1);
		
		for(int x = originX; x < originX+lengthX; x++){
			for(int y = originY; y < originY+lengthY;y++){
				for(int z = originZ; y < originZ+lengthZ;z++){
						
				}
			}
		}
		
	}

}
