package guru.haun.hackery.client.render;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HacKeyBinds;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class BSODRenderer extends Gui {
	private static boolean active = false;
	
	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){
		if(HacKeyBinds.debugkey.isPressed()){
			active = !active;
		}
		if(active){
			int x = e.resolution.getScaledWidth();
			int y = e.resolution.getScaledHeight();
			int xc = x >> 1;
			int yc = y >> 1;
			int h = 287;
			int w = 234;
			int xi = w >> 1;
			int yi = h >> 1;
			ResourceLocation res = new ResourceLocation("hackery:bsods/Sac_Mac.png");
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(res);
			this.drawTexturedModalRect(xc-xi, yc-yi, w, h, 0, 0);
		}
	}
	
}
