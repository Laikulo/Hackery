package guru.haun.hackery.worldgen;

import guru.haun.hackery.HackeryMod;

import java.util.Random;
import java.util.logging.Level;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GlitchPlacer implements IWorldGenerator {
	
	private HackeryMod instance;
	
	public void generate(Random rng, int cX, int cZ, World world, IChunkProvider chunkgen, IChunkProvider chunkprov) {
		//Overworld ONLY!!
		if(!world.provider.isSurfaceWorld() ) return;
		//Rarity Set
		if(rng.nextInt(150) != 0) return;
		
		
		int originX = cX << 4 + rng.nextInt(16);
		int originZ = cZ << 4 + rng.nextInt(16);
		int originY = rng.nextInt(47) + 3;
		
		int lengthX = (rng.nextInt(1) << 1) + 3;
		int lengthZ = (rng.nextInt(1) << 1)+ 3;
		int lengthY = rng.nextInt(3) + 6;
		
		int centerX = originX + (lengthX >> 1);
		int centerZ = originZ + (lengthZ >> 1);
		int centerY = originY + (lengthY >> 1);
		
		HackeryMod.logger.info(String.format("Spawned a thing at %d %d %d",originX,originY,originZ));
		
		for(int x = originX; x < originX+lengthX; x++){
			for(int y = originY; y < originY+lengthY;y++){
				for(int z = originZ; z < originZ+lengthZ;z++){
					if(world.getBlock(x, y, z).getBlockHardness(world, x, y, z) >= 0.0F){
						world.setBlockToAir(x, y, z);
					}
				}
			}
		}

		for(int x = originX; x < originX+lengthX; x++){
			world.setBlock(x, centerY, centerZ, HackeryMod.blockGlitch, 0, 3);
		}
		
		for(int y = originY; y < originY+lengthY; y++){
			world.setBlock(centerX, y, centerZ, HackeryMod.blockGlitch, 0, 3);
		}
		
		for(int z = originZ; z < originZ+lengthZ; z++){
			world.setBlock(centerX, centerY, z, HackeryMod.blockGlitch, 0, 3);
		}
		
		world.setBlock(centerX, centerY, centerZ, HackeryMod.blockGlitchCore, 0, 3);
		
		
	}

}
