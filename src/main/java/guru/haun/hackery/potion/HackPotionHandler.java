package guru.haun.hackery.potion;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	public void onRenderGameOverlay(RenderGameOverlayEvent e){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			int ticks = (int) e.partialTicks;
			if(ticks % 20 == 0){
				;
			}
		}
	}
}
