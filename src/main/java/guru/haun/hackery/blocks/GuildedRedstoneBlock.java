package guru.haun.hackery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class GuildedRedstoneBlock extends Block {

	protected GuildedRedstoneBlock() {
		super(Material.rock);
		setBlockName("guildedRedstone");
		setBlockTextureName("hackery:GoldRedstone");
		setHardness(1);
		setResistance(1);
		setHarvestLevel("pickaxe", 0);
	}
}
