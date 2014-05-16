package guru.haun.hackery.client.render;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HacKeyBinds;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class BSODRenderer {
	
	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){
		if(HacKeyBinds.debugkey.isPressed()){
			HackeryMod.logger.info("PING");
		}
	}
	
}
