package guru.haun.hackery.items;

import guru.haun.hackery.HackeryMod;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class GlitchHarvester extends ItemTool {

	private static float speed = 5;
	private static Set mineable = Sets.newHashSet(new Block []{ (Block)HackeryMod.blockGlitch});
	
	public GlitchHarvester(float speedOnProper, ToolMaterial creationMaterial,
			Set properBlocks) {
		super(speedOnProper, creationMaterial, properBlocks);
		setMaxDamage(3);
		setNoRepair();
		setMaxStackSize(1);
		setUnlocalizedName("glitchHarvester");
	}
	
	public Set<String> getToolClasses(ItemStack stack){
		return Sets.newHashSet(new String[] {"GlitchHarvester"});
	}
 
	//public int getTool
	
	public int getDamageVsEntity(){
		return 0;
	}
	
	//isCorrectForBlock
	public boolean func_150809_b(Block block){
		return block == HackeryMod.blockGlitch;
	}
	
	public GlitchHarvester(){
		this(speed,ToolMaterial.EMERALD,mineable);
	}
	

}
