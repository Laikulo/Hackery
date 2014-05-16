package guru.haun.hackery.blocks;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TraceAnalyzerContainer extends Container {

	protected TraceAnalyzerTE te;
	
	public TraceAnalyzerContainer(InventoryPlayer player, TraceAnalyzerTE te){
		this.te = te;
	}
}
