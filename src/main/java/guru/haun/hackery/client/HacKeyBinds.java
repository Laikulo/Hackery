package guru.haun.hackery.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class HacKeyBinds {
	public static KeyBinding debugkey;
	
	public HacKeyBinds (){
		debugkey = new KeyBinding( "key.debug", Keyboard.KEY_APOSTROPHE, "key.categories.hackery");
		ClientRegistry.registerKeyBinding(debugkey);
	}
}
