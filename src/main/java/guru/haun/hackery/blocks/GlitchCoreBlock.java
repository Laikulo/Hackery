package guru.haun.hackery.blocks;

import net.minecraft.block.material.Material;

public class GlitchCoreBlock extends GlitchBlock {

	public GlitchCoreBlock(Material mat) {
		super(mat);
		setBlockUnbreakable();
		setBlockName("blockGlitchCore");
		setBlockTextureName("hackery:GlitchCore");
		setLightLevel(0.2F);
	}

}
