package guru.haun.hackery.blocks.gui;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.HackeryMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.shader.TesselatorVertexState;

public class GuiBSOD extends GuiScreen {
	
	@Override
	public void drawScreen(int par1, int par2, float par3){
		this.drawDefaultBackground();
	}
	
	@Override
	public void initGui() {
		;
	}
	
	@Override
	public void updateScreen(){
		;
	}
	
	
	@Override
	public void keyTyped(char ascii, int scancode){
		mc.displayGuiScreen((GuiScreen) null);
		return;
	}
	
	
}
