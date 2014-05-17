package guru.haun.hackery.client;

import net.minecraft.client.Minecraft;
import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.blocks.gui.GuiBSOD;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class HacKeyHandler {
	
	@SubscribeEvent
	public void onKeyEvent(InputEvent.KeyInputEvent e){
		if(HacKeyBinds.debugkey.isPressed()){
			Minecraft.getMinecraft().displayGuiScreen(new GuiBSOD());
		}
	}
	
	

}
