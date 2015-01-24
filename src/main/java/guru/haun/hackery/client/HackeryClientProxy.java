package guru.haun.hackery.client;

import guru.haun.hackery.HackeryCommonProxy;
import guru.haun.hackery.blocks.gui.GuiBSOD;
import guru.haun.hackery.potion.HackPotionHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class HackeryClientProxy extends HackeryCommonProxy {
	
	public void registerRenderThings(){
		FMLCommonHandler.instance().bus().register(new HackPotionHandler());;
	}
	
	public void registerKeyBinds(){
		//FMLCommonHandler.instance().bus().register(new HacKeyBinds());
		//FMLCommonHandler.instance().bus().register(new HacKeyHandler());
	}
	
	public void setBSODState(boolean state){
		if(state)
			Minecraft.getMinecraft().displayGuiScreen(new GuiBSOD());
		else
			if(Minecraft.getMinecraft().currentScreen instanceof GuiBSOD)
				Minecraft.getMinecraft().displayGuiScreen((GuiScreen) null);
	}

    @Override
    public void registerServerCommands() {
        ;
    }
}
