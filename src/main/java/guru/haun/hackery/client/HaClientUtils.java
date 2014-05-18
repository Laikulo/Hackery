package guru.haun.hackery.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import guru.haun.hackery.HackeryMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.util.JsonException;
import net.minecraft.util.ResourceLocation;

public class HaClientUtils {

	@SideOnly(Side.CLIENT)
	public static void setShader(ResourceLocation sha){
		Minecraft mc = Minecraft.getMinecraft();
		mc.entityRenderer.theShaderGroup = new ShaderGroup(mc.getResourceManager(), mc.getFramebuffer(), sha);
		mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
	}
	
}
