package guru.haun.hackery.blocks.render;

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
		
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_SRC_COLOR);
		GL11.glEnable(GL11.GL_BLEND);
		this.model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

}
