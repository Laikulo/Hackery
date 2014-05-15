package guru.haun.hackery;

import guru.haun.hacker.material.GlitchMaterial;
import guru.haun.hackery.blocks.GlitchBlock;
import guru.haun.hackery.blocks.GlitchCoreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid="hackery", name="Hackers", version = "modjam")
public class HackeryMod {
	

	@EventHandler
	public void HackeryPreInit(FMLPreInitializationEvent e){

		//Glitch Blocks
		Material 	matGlitch			= new GlitchMaterial(MapColor.purpleColor);
		Block 		blockGlitch			= new GlitchBlock(matGlitch);
		Block		blockGlitchCore		= new GlitchCoreBlock(matGlitch);
		
		GameRegistry.registerBlock(blockGlitchCore, "blockGlitchCore");
		GameRegistry.registerBlock(blockGlitch, "blockGlitch");
		
	}
	
	
	@EventHandler
	public void HackeryInit(FMLInitializationEvent e){
		
	}
	
	
	@EventHandler
	public void HackeryPostInit(FMLPostInitializationEvent e){
		
	}
	
	
}
