package guru.haun.hackery.blocks.gui;

import guru.haun.hackery.HackeryMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.shader.TesselatorVertexState;

public class GuiBSOD extends GuiScreen {
	
	@Override
	public void initGui() {
		HackeryMod.logger.info("Test");
		Tessellator tess = Tessellator.instance;
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
