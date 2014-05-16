package guru.haun.hackery.client.gui;

import guru.haun.hackery.blocks.TraceAnalyzerContainer;
import guru.haun.hackery.blocks.TraceAnalyzerTE;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

public class TraceAnalyzerGUI extends GuiContainer {

	public TraceAnalyzerGUI (InventoryPlayer inventoryPlayer, TraceAnalyzerTE te) {
		super(new TraceAnalyzerContainer(inventoryPlayer,te));
	}
	
	protected void drawGuiContainerForegroundLayer(int a, int b){
		fontRendererObj.drawString("StackTrace Analyzer", 8, 8, 4210752);
	}
	
	protected void drawGuiContainerBackgroundLayer(float a, int b, int c) {
		int x = (width - xSize) /2;
		int y = (height - ySize) /2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
