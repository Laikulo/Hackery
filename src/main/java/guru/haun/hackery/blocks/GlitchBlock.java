package guru.haun.hackery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GlitchBlock extends Block {

	protected GlitchBlock(Material mat) {
		super(mat);
		setResistance(9000000);
		setLightLevel(4);
	}

}
