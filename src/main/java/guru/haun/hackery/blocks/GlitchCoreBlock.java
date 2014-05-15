package guru.haun.hackery.blocks;

import net.minecraft.block.material.Material;

public class GlitchCoreBlock extends GlitchBlock {

	public GlitchCoreBlock(Material mat) {
		super(mat);
		setBlockUnbreakable();
		setBlockName("blockGlitchCore");
		this.setBlockTextureName("hackery:GlitchCore");
	}

}
