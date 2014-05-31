package guru.haun.hackery.items;

import guru.haun.hackery.HackeryMod;

import java.util.Set;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

public class GlitchHarvester extends ItemTool {

	private static float speed = 5;
	private static Set mineable = Sets.newHashSet(new Block []{ (Block)HackeryMod.blockGlitch});
	
	public GlitchHarvester registerRecipie(){
		ItemStack resultstack = new ItemStack(this);
		GameRegistry.addRecipe(resultstack, " E ","eRe","rsr",
								'r',	new ItemStack(Items.redstone,1,0),
								'e',	new ItemStack(Items.emerald,1,0),
								'E',	new ItemStack(Item.getItemFromBlock(Blocks.emerald_block),1,0),
								'R',	new ItemStack(Item.getItemFromBlock(Blocks.redstone_block),1,0),
								's',	new ItemStack(Items.stick,1,0)
								);
		return this;
	}
	
	public GlitchHarvester(float speedOnProper, ToolMaterial creationMaterial,
			Set properBlocks) {
		super(speedOnProper, creationMaterial, properBlocks);
		setMaxDamage(7);
		setNoRepair();
		setMaxStackSize(1);
		setUnlocalizedName("glitchHarvester");
		setHarvestLevel("GlitchHarvester",1);
		setTextureName("hackery:GlitchHarvester");
	}
	
	//Not a sword
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entitiy){
		if(!player.worldObj.isRemote){
			player.addChatMessage(new ChatComponentText("<").appendSibling(
					new ChatComponentText("fs|r5g").setChatStyle(new ChatStyle().setObfuscated(true)).appendSibling(
					new ChatComponentText("> That is not a sword, it is a expensive piece of equipment!").setChatStyle(new ChatStyle().setObfuscated(false))))
					);
		}
		stack.damageItem(1, player);
		if(stack.getItemDamage() <= 3){
			stack.stackSize--;
		}
		return true; //stop the attack
	}
	
	
	public Set<String> getToolClasses(ItemStack stack){
		return Sets.newHashSet(new String[] {"GlitchHarvester"});
	}
 
	
	//isCorrectForBlock
	public boolean func_150809_b(Block block){
		return block == HackeryMod.blockGlitch;
	}
	
	public GlitchHarvester(){
		this(speed,ToolMaterial.EMERALD,mineable);
	}
	
}
