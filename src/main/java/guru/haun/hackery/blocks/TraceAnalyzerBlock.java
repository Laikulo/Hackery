package guru.haun.hackery.blocks;

import guru.haun.hackery.HackeryMod;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TraceAnalyzerBlock extends BlockContainer {

	
	public void registerRecipie() {
		GameRegistry.addShapelessRecipe(new ItemStack(this,1,0), new ItemStack(HackeryMod.blockEmeraldGlass,1,0), new ItemStack(HackeryMod.blockGuildedRedstone,1,0) );
	}
	
	public TraceAnalyzerBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		setUnlocalizedName("traceAnalyzer");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TraceAnalyzerTE();
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity te = worldIn.getTileEntity(pos);
		if(te==null || playerIn.isSneaking()) return false;
		playerIn.openGui(HackeryMod.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}


}
