package guru.haun.hackery.potion;

import scala.util.Random;
import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HaClientUtils;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	private static boolean laststate = false;
	private static long lasttick = 0;
	private static int nexttick = 10;
	private static float oldeye;
	
	private static final String[] niceShaders = new String[] {"bits","bumpy","color_convolve","green","ntsc","phosphor","sobel"};
	
	private void shuffleShader(){
		String shadername = niceShaders[(int) ((float)niceShaders.length * Math.random())];
		shadername = String.format("minecraft:shaders/post/%s.json",shadername);
		HaClientUtils.setShader(new ResourceLocation(shadername));
	}
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent e){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer == null) return;
		if(laststate != mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
				//On activateion
				shuffleShader();
				oldeye = mc.thePlayer.eyeHeight;
			}else{
				//On deactivation
				mc.entityRenderer.deactivateShader();
				mc.thePlayer.eyeHeight = oldeye;
			}
			laststate = mc.thePlayer.isPotionActive(HackPotions.potionGF);
		}
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			long ticks = mc.theWorld.getWorldTime();
			if(ticks != lasttick && ( ticks % (20 + nexttick) == 0)){
				shuffleShader();
				mc.thePlayer.eyeHeight = (float) (1.9f * Math.random() + .1f);
				lasttick = ticks;
				nexttick = (int) (20f * Math.random());
			}
		}
		
		
	}
	
}
