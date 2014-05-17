package guru.haun.hackery.potion;

import scala.util.Random;
import guru.haun.hackery.HackeryMod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	private static boolean laststate = false;
	private static long lasttick = 0;
	private static int nexttick = 10;
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent e){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer == null) return;
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			long ticks = mc.theWorld.getWorldTime();
			if(ticks != lasttick && ( ticks % (20 + nexttick) == 0)){
				mc.entityRenderer.activateNextShader();
				lasttick = ticks;
				nexttick = (int) (20f * Math.random());
			}
			mc.thePlayer.eyeHeight = (float) (1.9f * Math.random() + .1f);
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
