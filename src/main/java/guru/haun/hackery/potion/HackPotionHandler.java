package guru.haun.hackery.potion;

import guru.haun.hackery.HackeryMod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	private static boolean laststate = false;
	private long lasttick = 0;
	
	@SubscribeEvent
	@EventHandler
	public void onRenderGameOverlay(RenderGameOverlayEvent e){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			long ticks = mc.theWorld.getWorldTime();
			if(ticks != lasttick && ticks % 80 == 0){
				mc.entityRenderer.activateNextShader();
				lasttick = ticks;
			}
		}
		if(laststate != mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
				//On activateion
				mc.entityRenderer.activateNextShader();
			}else{
				//On deactivation
				mc.entityRenderer.deactivateShader();
			}
			laststate = mc.thePlayer.isPotionActive(HackPotions.potionGF);
		}
		
	}
	
}
