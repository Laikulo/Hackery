package guru.haun.hackery.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class HackPotion extends Potion {
	public HackPotion(int par1, boolean par2, int par3){
		super(par1,par2,par3);
        setEffectiveness(.25D);
	}
	
	@Override
	public void performEffect(EntityLivingBase elb, int foo){
		return;
	}
	
	@Override
	public void affectEntity(EntityLivingBase elb, EntityLivingBase elb2, int i, double d){
		return;
	}

}
