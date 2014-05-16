package guru.haun.hackery.blocks;

import guru.haun.hackery.HackeryMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TraceAnalyzerBlock extends BlockContainer {

	
	public void registerRecipie() {
		GameRegistry.addShapelessRecipe(new ItemStack(this,1,0), new ItemStack(HackeryMod.blockEmeraldGlass,1,0), new ItemStack(HackeryMod.blockGuildedRedstone,1,0) );
	}
	
	public TraceAnalyzerBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockName("traceAnalyzer");
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
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float a, float b, float c) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te == null || player.isSneaking()) return false;
		player.openGui(HackeryMod.instance, 0, world, x, y, z);
		return true;
	}

}
