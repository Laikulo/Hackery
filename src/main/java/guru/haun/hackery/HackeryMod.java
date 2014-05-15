package guru.haun.hackery;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid="hackery", name="Hackers", version = "modjam")
public class HackeryMod {
	

	@EventHandler
	public void HackeryPreInit(FMLPreInitializationEvent e){

		//Glitch Blocks
		Material 	matGlitch			= new GlitchMaterial()
		Block 		blockGlitch			= new GlitchBlock()
		Block		blockGlitchCore		= new GlitchBlockCore()
		
	}
	
	
	@EventHandler
	public void HackeryInit(FMLInitializationEvent e){
		
	}
	
	
	@EventHandler
	public void HackeryPostInit(FMLPostInitializationEvent e){
		
	}
	
	
}
