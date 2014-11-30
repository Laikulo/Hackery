package guru.haun.hackery.blocks.gui;

import guru.haun.hackery.blocks.TraceAnalyzerContainer;
import guru.haun.hackery.blocks.TraceAnalyzerTE;
import guru.haun.hackery.client.gui.TraceAnalyzerGUI;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
		if(te instanceof TraceAnalyzerTE){
			return new TraceAnalyzerContainer(player.inventory, (TraceAnalyzerTE) te);
		}
		return null;
	}
	
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
		if(te instanceof TraceAnalyzerTE){
			return new TraceAnalyzerGUI(player.inventory, (TraceAnalyzerTE) te);
		}
		return null;
	}
}
