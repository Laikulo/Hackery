package guru.haun.hackery.blocks;

import org.lwjgl.opengl.GL11;

import guru.haun.hackery.client.render.model.ModelTraceAnalyzer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TraceAnalyzerRenderer extends TileEntitySpecialRenderer {

	private final ModelTraceAnalyzer model;
	
	public TraceAnalyzerRenderer() {
		this.model = new ModelTraceAnalyzer();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5F, (float) y + 1.5F, (float) z + .5F);
		ResourceLocation tex = (new ResourceLocation("hackery:textures/blocks/TraceAnalyzer.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
		
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0F, 0F, 1F);
		this.model.render((Entity) null, 0F, 0F, -.1F, 0F, 0F, 0.0655F);
		GL11.glPopMatrix();
		GL11.glPopAttrib();
	}

}
