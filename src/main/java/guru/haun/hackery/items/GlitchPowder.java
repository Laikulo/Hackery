package guru.haun.hackery.items;

import cpw.mods.fml.common.registry.GameRegistry;
import guru.haun.hackery.HackeryMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class GlitchPowder extends Item{
	
	public GlitchPowder(boolean register) {
		setUnlocalizedName("powderGlitch");
		setTextureName("hackery:GlitchPowder");
		if(register){
			GameRegistry.registerItem(this, "glitchPowder");
			GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0), new ItemStack(HackeryMod.shardGlitch, 1, 0), new ItemStack(HackeryMod.shardGlitch, 1, 0), new ItemStack(HackeryMod.shardGlitch, 1, 0), new ItemStack(HackeryMod.shardGlitch, 1, 0));
			registerPotion();
			this.setPotionEffect(HackeryMod.config.gpPotionEff);
			this.setCreativeTab(HackeryMod.creativetab);
		}
	}
	
	@Override
	public boolean isPotionIngredient(ItemStack is){
		return true;
	}
	
	public void registerPotion(){
		try{
			Class potHepler = PotionHelper.class;
			Field potFields[] = potHepler.getDeclaredFields();
			for(Field f : potFields){
				if(f.getName().equals("potionRequirements") || f.getName().equals("field_77927_l")){
					HackeryMod.logger.info("Registering potion effects...");
					f.setAccessible(true);
					HashMap<Integer,String> newReq = ((HashMap<Integer,String>)f.get(null));
					newReq.put(HackeryMod.config.idEffectGlitch, HackeryMod.config.gfPotionReq);
				}
			}
		}catch (Exception e){
			HackeryMod.logger.error("Something went wrong while registering potions!");
			e.printStackTrace();
		}
		HackeryMod.logger.info("Break Here!");
	}

    @Override
    public void getSubItems(Item i, CreativeTabs tab, List l) {
        l.add(new ItemStack(this,1,0));
        l.add(new ItemStack(Items.potionitem,1,9243));
        l.add(new ItemStack(Items.potionitem,1,9307));
        l.add(new ItemStack(Items.potionitem,1,17435));
        l.add(new ItemStack(Items.potionitem,1,17499));
    }


}
