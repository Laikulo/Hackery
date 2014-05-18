package guru.haun.hackery.potion;

import scala.util.Random;
import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.client.HaClientUtils;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HackPotionHandler {

	private static boolean laststate = false;
	private static long lasttick = 0;
	private static int nexttick = 10;
	private static long lastheadtick = 0;
	
	private static final String[] niceShaders = new String[] {"bits","bumpy","deconverge","green","ntsc","phosphor","sobel"};
	
	private void shuffleShader(){
		String shadername = niceShaders[(int) ((float)niceShaders.length * Math.random())-1];
		shadername = String.format("minecraft:shaders/post/%s.json",shadername);
		HaClientUtils.setShader(new ResourceLocation(shadername));
	}
	
	private void jerkHead(){
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		player.rotationYawHead =  (player.rotationYawHead + ((60f * (float) Math.random()) - 30f));
		player.rotationYaw =  (player.rotationYaw + ((60f * (float) Math.random()) - 30f));
		player.rotationPitch = (player.rotationPitch + ((60f * (float) Math.random()) - 30f));
	}
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent e){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer == null) return;
		if(laststate != mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
				//On activateion
				shuffleShader();
			}else{
				//On deactivation
				mc.entityRenderer.deactivateShader();
			}
			laststate = mc.thePlayer.isPotionActive(HackPotions.potionGF);
		}
		if(mc.thePlayer.isPotionActive(HackPotions.potionGF)){
			long ticks = mc.theWorld.getWorldInfo().getWorldTotalTime();
			if(ticks != lasttick && ( ticks % (20 + nexttick) == 0)){
				shuffleShader();
				lasttick = ticks;
				nexttick = (int) (20f * Math.random());
			}
			if(ticks != lastheadtick && (ticks & 1) == 0){
				jerkHead();
				lastheadtick = ticks;
			}
		}
		
		
	}
	
}
