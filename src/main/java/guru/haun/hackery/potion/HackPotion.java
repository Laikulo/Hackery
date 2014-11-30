package guru.haun.hackery.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class HackPotion extends Potion {
	protected HackPotion(int p_i45897_1_, ResourceLocation p_i45897_2_, boolean p_i45897_3_, int p_i45897_4_) {
		super(p_i45897_1_, p_i45897_2_, p_i45897_3_, p_i45897_4_);
		setEffectiveness(.25D);
	}

	
	@Override
	public void performEffect(EntityLivingBase elb, int foo){
		return;
	}


}
