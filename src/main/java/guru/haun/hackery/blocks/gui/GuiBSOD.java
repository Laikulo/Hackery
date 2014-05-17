package guru.haun.hackery.blocks.gui;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.HackeryMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.shader.TesselatorVertexState;
import net.minecraft.util.ResourceLocation;

public class GuiBSOD extends GuiScreen {
	
	@Override
	public void drawScreen(int par1, int par2, float par3){
		this.zLevel = 0F;
		this.drawGradientRect(0, 0, this.width, this.width, 0xFF000000, 0xFF000000 );
		mc.renderEngine.bindTexture(new ResourceLocation("hackery:bsods/Sad Notch.png"));
		int texturesize = 256;
		int centerX = this.width >> 1;
		int centerY = this.height >> 1;
		int imageCenterX = texturesize >> 1;
		int imageCenterY = texturesize >> 1;
		this.zLevel = 1F;
		this.drawTexturedModalRect(centerX - imageCenterX, centerY - imageCenterY, 0, 0, texturesize, texturesize);
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
		return;
	}
	
	
}
