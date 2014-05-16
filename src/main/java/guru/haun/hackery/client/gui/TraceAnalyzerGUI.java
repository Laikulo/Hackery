package guru.haun.hackery.client.gui;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.blocks.TraceAnalyzerContainer;
import guru.haun.hackery.blocks.TraceAnalyzerTE;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class TraceAnalyzerGUI extends GuiContainer {
	
	private TraceAnalyzerTE te;

	public TraceAnalyzerGUI (InventoryPlayer inventoryPlayer, TraceAnalyzerTE te) {
		super(new TraceAnalyzerContainer(inventoryPlayer,te));
		this.te = te;
	}
	
	protected void drawGuiContainerForegroundLayer(int a, int b){
		fontRendererObj.drawString("CoreDump Analyzer", 8, 8, 4210752);
	}
	
	protected void drawGuiContainerBackgroundLayer(float a, int b, int c) {
		ResourceLocation texture = new ResourceLocation("hackery:gui/simple2pane.png");
		mc.renderEngine.getTexture(texture);
		GL11.glColor4f(1F,1F,1F,1F);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) /2;
		int y = (height - ySize) /2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		int prog = this.te.getScaledProgress(24);		
		this.drawTexturedModalRect(x + 79, y + 34, 176, 0, prog + 1, 16);
		
	}
}
