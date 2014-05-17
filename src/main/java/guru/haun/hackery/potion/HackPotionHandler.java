package guru.haun.hackery.potion;

import guru.haun.hackery.HackeryMod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	@SubscribeEvent
	@EventHandler
	public void onRenderGameOverlay(RenderGameOverlayEvent e){
		HackeryMod.logger.info("Ping");
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			int ticks = (int) e.partialTicks;
			if(ticks % 20 == 0){
				mc.entityRenderer.activateNextShader();
			}
		}
	}
	
}
