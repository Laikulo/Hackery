package guru.haun.hackery;

import guru.haun.hacker.material.GlitchMaterial;
import guru.haun.hackery.blocks.GlitchBlock;
import guru.haun.hackery.blocks.GlitchCoreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid="hackery", name="Hackers", version = "modjam")
public class HackeryMod {
	
	@Instance("hackery")
	public static HackeryMod instance;
	
	//Glitch Blocks
	public static GlitchMaterial		matGlitch			= new GlitchMaterial(MapColor.purpleColor);
	public static GlitchBlock 		blockGlitch			= new GlitchBlock(matGlitch);
	public static GlitchCoreBlock		blockGlitchCore		= new GlitchCoreBlock(matGlitch);
		
		
	public static CreativeTabs creativetab = new CreativeTabs("tabHackery") {
		public ItemStack getIconItemStack() {
			return new ItemStack(
	};
	

	@EventHandler
	public void HackeryPreInit(FMLPreInitializationEvent e){
		
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
