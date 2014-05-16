package guru.haun.hackery.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GuildedRedstoneBlock extends Block {

	public void registerRecipie() {
		GameRegistry.addRecipe(new ItemStack(this,1,0), "ggg","grg","ggg",
					'g', new ItemStack(Items.gold_ingot,1,0),
					'r', new ItemStack(Item.getItemFromBlock(Blocks.redstone_block),1,0));
	}
	
	public GuildedRedstoneBlock() {
		super(Material.rock);
		setBlockName("guildedRedstone");
		setBlockTextureName("hackery:GoldRedstone");
		setHardness(1);
		setResistance(1);
		setHarvestLevel("pickaxe", 0);
	}
}
