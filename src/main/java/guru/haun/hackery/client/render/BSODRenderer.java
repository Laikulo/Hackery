package guru.haun.hackery.client.render;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HacKeyBinds;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class BSODRenderer extends Gui {
	public static boolean active = false;
	private boolean laststate;
	private boolean oldguistate;
	
	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){
		if(active){
			int x = e.resolution.getScaledWidth();
			int y = e.resolution.getScaledHeight();
			int xc = x >> 1;
			int yc = y >> 1;
			int w = 256;
			int h = 256;
			int xi = w >> 1;
			int yi = h >> 1;
			
			Tessellator tess = Tessellator.instance;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glColor4f(0, 0, 0, 1F);
			
			tess.startDrawingQuads();
			tess.addVertex((double) 0, (double) y, 0D);
			tess.addVertex((double) x, (double) y, 0D);
			tess.addVertex((double) x, (double) 0, 0D);
			tess.addVertex((double) 0, (double) 0, 0D);
			tess.draw();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			
			//ResourceLocation res = new ResourceLocation("hackery:bsods/Sad Notch.png");
			//Minecraft.getMinecraft().renderEngine.bindTexture(res);
			//this.drawTexturedModalRect(xc-xi, yc-yi, 0, 0, w, h);
		}
	}
	
}
