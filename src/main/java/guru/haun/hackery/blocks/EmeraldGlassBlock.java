package guru.haun.hackery.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EmeraldGlassBlock extends Block {
	
	public void registerRecipie(){
		GameRegistry.addRecipe(new ItemStack(this,1,0),
				"eee","ege","eee",
				'e', new ItemStack(Items.emerald,1,0),
				'g', new ItemStack(Item.getItemFromBlock(Blocks.glass),1,0)
				);
	}
	
	public EmeraldGlassBlock() {
		super(Material.glass);
		setBlockName("emeraldGlass");
		setBlockTextureName("hackery:EmeraldGlass");
		setHardness(1);
		setResistance(1);
		setHarvestLevel("pickaxe",1);
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public int getRenderPass(){
		return 1;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
}
