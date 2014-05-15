package guru.haun.hackery.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class GlitchMaterial extends Material {

	public GlitchMaterial(MapColor par1MapColor) {
		super(par1MapColor);
		setImmovableMobility();
		setRequiresTool();
	}
	
	public boolean isSolid() {
		return false;
	}

}
