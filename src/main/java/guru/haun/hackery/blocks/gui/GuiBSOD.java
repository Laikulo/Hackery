package guru.haun.hackery.blocks.gui;

import guru.haun.hackery.HackeryMod;
import net.minecraft.client.gui.GuiScreen;

public class GuiBSOD extends GuiScreen {
	
	@Override
	public void keyTyped(char c, int i){
		HackeryMod.logger.info(String.format("c %d i %d", (int)c, i));
	}
	
}
