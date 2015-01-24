package guru.haun.hackery.client;

import guru.haun.hackery.HackeryMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HaClientUtils {
	@SideOnly(Side.CLIENT)
	public static void setShader(ResourceLocation sha){
		Minecraft mc = Minecraft.getMinecraft();
        try {
            throw new RuntimeException("Not yet implemented in 1.8");
            /*ShaderGroup theShader;
            theShader = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), sha);
            ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, mc.entityRenderer, theShader, "theShaderGroup");*/
        } catch (Exception e) {
            HackeryMod.logger.error("Something bad happened while swapping shaders");
            e.printStackTrace();
        }
	}
	
}
