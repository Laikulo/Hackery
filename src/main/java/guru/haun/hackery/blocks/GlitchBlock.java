package guru.haun.hackery.blocks;

import sun.awt.windows.WWindowPeer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class GlitchBlock extends Block {

	public GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setBlockName("blockGlitch");
		setLightOpacity(3);
		setBlockTextureName("hackery:Glitch");
	}
	
	public void setBlockBoundsBasedOnState(World world, int x, int y, int z){
		float x1 = .35F;
		float y1 = .35F;
		float z1 = .35F;
		float x2 = .65F;
		float y2 = .65F;
		float z2 = .65F;
		
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
		this.setBlockBounds(x1,y1,z1,x2,y2,z2);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	public MovingObjectPosition collisionRayTrace(World w, int x, int y, int z, Vec3 a, Vec3 b){
		this.setBlockBoundsBasedOnState(w, x, y, z);
		return super.collisionRayTrace(w, x, y, z, a, b);
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
