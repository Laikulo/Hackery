package guru.haun.hackery.worldgen;

import guru.haun.hackery.HackeryMod;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

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
		
		int lengthX = (rng.nextInt(2) << 1) + 3;
		int lengthZ = (rng.nextInt(2) << 1) + 3;
		int lengthY = (rng.nextInt(2) << 1) + 3;
		
		int centerX = originX + (lengthX >> 1);
		int centerZ = originZ + (lengthZ >> 1);
		int centerY = originY + (lengthY >> 1);

		BlockPos position;
		for(int x = originX; x < originX+lengthX; x++){
			for(int y = originY; y < originY+lengthY;y++){
				for(int z = originZ; z < originZ+lengthZ;z++){
					position = new BlockPos(x,y,z);
					if(world.getChunkFromBlockCoords(position).getBlock(position).getBlockHardness(world, position) >= 0.0F){
						world.setBlockToAir(position);
					}
				}
			}
		}

		for(int x = originX; x < originX+lengthX; x++){
			world.setBlockState(new BlockPos(x, centerY, centerZ), HackeryMod.blockEmeraldGlass.getDefaultState(), 3);
		}
		
		for(int y = originY; y < originY+lengthY; y++){
			world.setBlockState(new BlockPos(centerX, y, centerZ), HackeryMod.blockGlitch.getDefaultState(), 3);
		}
		
		for(int z = originZ; z < originZ+lengthZ; z++){
			world.setBlockState(new BlockPos(centerX, centerY, z), HackeryMod.blockGlitch.getDefaultState(), 3);
		}
		
		world.setBlockState(new BlockPos(centerX, centerY, centerZ), HackeryMod.blockGlitchCore.getDefaultState(), 3);
		
		
	}

}
