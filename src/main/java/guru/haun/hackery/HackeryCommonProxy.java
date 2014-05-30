package guru.haun.hackery;

import guru.haun.hackery.command.nsodCommand;
import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;

public class HackeryCommonProxy {

	
	public void registerRenderThings() {
		;
	}
		
	public void registerKeyBinds() {
		;
	}
	
	public void setBSODState(boolean state) {
		;
	}

    public void registerServerCommands() {
        ((CommandHandler) MinecraftServer.getServer().getCommandManager()).registerCommand(new nsodCommand());
    }

		
}
