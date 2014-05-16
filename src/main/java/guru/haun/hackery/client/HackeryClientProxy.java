package guru.haun.hackery.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import guru.haun.hackery.HackeryCommonProxy;
import guru.haun.hackery.blocks.TraceAnalyzerTE;
import guru.haun.hackery.client.render.BSODRenderer;
import guru.haun.hackery.client.render.TraceAnalyzerRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class HackeryClientProxy extends HackeryCommonProxy {
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TraceAnalyzerTE.class, new TraceAnalyzerRenderer());
		MinecraftForge.EVENT_BUS.register(new BSODRenderer());
	}
}
