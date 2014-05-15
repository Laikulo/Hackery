package guru.haun.hackery.blocks;

import sun.awt.windows.WWindowPeer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class GlitchBlock extends Block {

	public GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setBlockName("blockGlitch");
		setLightOpacity(3);
		setBlockTextureName("hackery:Glitch");
		
	}
	
	void setBoundsFromMetaData(IBlockAccess ba, int x, int y, int z) {
		float x1 = .35F;
		float y1 = .35F;
		float z1 = .35F;
		float x2 = .65F;
		float y2 = .65F;
		float z2 = .65F;
		
		switch(ba.getBlockMetadata(x, y, z)){
		case 1:
			x1 = 0F;
			x2 = 1F;
			break;
		case 2:
			y1 = 0F;
			y2 = 1F;
			break;
		case 3:
			y1 = 0F;
			y2 = 1F;
			break;
		default:
			break;
		}
		this.setBlockBounds(x1, y1, z1, x2, y2, z2);
	}
	
	public int onBlockPlaced(World w, int x, int y, int z, int side, float i, float j, float k, int metadata ){
		return 0;
	}
	
	private int ditermineMetadata(World w, int x, int y, int z){
		if(w.getBlock(x + 1, y, z).equals(this) || w.getBlock(x - 1, y, z).equals(this)){
			return 1;
		}
		if(w.getBlock(x, y + 1, z).equals(this) || w.getBlock(x, y - 1, z).equals(this)){
			return 2;
		}
		if(w.getBlock(x, y, z + 1).equals(this) || w.getBlock(x, y, z - 1).equals(this)){
			return 3;
		}
		return 0;
	}
	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		this.setBoundsFromMetaData(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		this.setBoundsFromMetaData(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	public MovingObjectPosition collisionRayTrace(World w, int x, int y, int z, Vec3 a, Vec3 b){
		this.setBoundsFromMetaData(w, x, y, z);
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
	
	public boolean getBlocksMovement(IBlockAccess ba, int x, int y, int z){
		return true;
	}
	
}
