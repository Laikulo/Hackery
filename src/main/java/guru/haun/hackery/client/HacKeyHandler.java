package guru.haun.hackery.client;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.render.BSODRenderer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class HacKeyHandler {
	
	@SubscribeEvent
	public void onKeyEvent(InputEvent.KeyInputEvent e){
		if(HacKeyBinds.debugkey.isPressed()){
			BSODRenderer.active = !BSODRenderer.active;
			HackeryMod.logger.warn(String.format("BSOD %s",BSODRenderer.active));
		}
	}
	
	

}
