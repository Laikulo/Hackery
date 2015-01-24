package guru.haun.hackery.blocks;

import guru.haun.hackery.HackeryMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class GlitchBlock extends Block {

	public GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setHardness(4);
		setUnlocalizedName("blockGlitch");
		setLightOpacity(0);
		setBlockBounds(.35F,.35F,.35F,.65F,.65F,.65F);
		setHarvestLevel("GlitchHarvester", 1);
	}

	@Override
	public boolean removedByPlayer(World world, BlockPos pos, EntityPlayer p, boolean willHarvest) {
		if(p instanceof FakePlayer) return false;
		if(!p.capabilities.isCreativeMode) return super.removedByPlayer(world, pos, p, willHarvest);
		else if(p.getHeldItem() == null) return false;
		else if(p.getHeldItem().getItem() == null) return false;
		else if(p.getHeldItem().getItem() != HackeryMod.glitchHarvester) return false;
		return super.removedByPlayer(world, pos, p, willHarvest);
	}

	
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}
	
}
