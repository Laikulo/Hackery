package guru.haun.hackery.blocks;

import sun.awt.windows.WWindowPeer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class GlitchBlock extends Block {

	public GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setBlockName("blockGlitch");
		setLightOpacity(3);
		setBlockTextureName("hackery:Glitch");
		setBlockBounds(.35F,.35F,.35F,.65F,.65F,.65F);
	}
	
	public void setBlockBoundsBasedOnState(World w, int x, int y, int z) {
		if(w.getBlock(x+1, y, z).equals(this) || w.getBlock(x-1, y, z).equals(this)){
			this.setBlockBounds(0F,.35F,.35F,1F,.65F,.65F);
			return;
		}
		if(w.getBlock(x, y+1, z).equals(this) || w.getBlock(x, y-1, z).equals(this)){
			this.setBlockBounds(.35F,0F,.35F,.65F,1F,.65F);
			return;
		}
		if(w.getBlock(x, y, z+1).equals(this) || w.getBlock(x, y, z-1).equals(this)){
			this.setBlockBounds(.35F,.35F,0F,.65F,.65F,1F);
			return;
		}
		this.setBlockBounds(.35F,.35F,.35F,.65F,.65F,.65F);
		
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
