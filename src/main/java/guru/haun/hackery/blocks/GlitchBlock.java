package guru.haun.hackery.blocks;

import sun.awt.windows.WWindowPeer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class GlitchBlock extends Block {

	public GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setBlockName("blockGlitch");
		setLightOpacity(3);
		setBlockTextureName("hackery:Glitch");
	}
	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		double x1 = .35F;
		double y1 = .35F;
		double z1 = .35F;
		double x2 = .65F;
		double y2 = .65F;
		double z2 = .65F;
		
		if(world.getBlock(x + 1, y, z).equals(this) || world.getBlock(x - 1, y, z).equals(this)){
			x1 = 0;
			x2 = 1;
		}else if(world.getBlock(x, y + 1, z).equals(this) || world.getBlock(x, y - 1,z).equals(this)){
			y1 = 0;
			y2 = 1;
		}else if(world.getBlock(x, y, z + 1).equals(this) || world.getBlock(x, y, z - 1).equals(this)){
			z1 = 0;
			z2 = 1;
		}
		
		x1 += x;
		x2 += x;
		y1 += y;
		y2 += y;
		z1 += z;
		z2 += z;
		
		return AxisAlignedBB.getAABBPool().getAABB(x1,y1,z1,x2,y2,z2);
	}
	
	
	@SideOnly(Side.CLIENT)
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}
	
}
