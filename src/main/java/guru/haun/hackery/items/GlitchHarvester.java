package guru.haun.hackery.items;

import guru.haun.hackery.HackeryMod;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class GlitchHarvester extends ItemTool {

	private static float speed = 200;
	private static Set mineable = Sets.newHashSet(new Block []{ (Block)HackeryMod.blockGlitch});
	
	public GlitchHarvester(float speedOnProper, ToolMaterial creationMaterial,
			Set properBlocks) {
		super(speedOnProper, creationMaterial, properBlocks);
		setMaxDamage(3);
		setNoRepair();
		setMaxStackSize(1);
		setUnlocalizedName("glitchHarvester");
		setHarvestLevel("GlitchHarvester", 0);
	}
	
	public Set<String> getToolClasses(ItemStack stack){
		return Sets.newHashSet(new String[] {"GlitchHarvester"});
	}
	
	public GlitchHarvester(){
		this(speed,ToolMaterial.EMERALD,mineable);
	}
	

}
