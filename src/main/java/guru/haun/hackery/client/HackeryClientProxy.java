package guru.haun.hackery.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import guru.haun.hackery.HackeryCommonProxy;
import guru.haun.hackery.blocks.TraceAnalyzerTE;
import guru.haun.hackery.client.render.TraceAnalyzerRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class HackeryClientProxy extends HackeryCommonProxy {
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TraceAnalyzerTE.class, new TraceAnalyzerRenderer());
	}
	
	public void registerKeyBinds(){
		FMLCommonHandler.instance().bus().register(new HacKeyBinds());
		FMLCommonHandler.instance().bus().register(new HacKeyHandler());
	}
}
