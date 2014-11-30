package guru.haun.hackery.potion;

import guru.haun.hackery.HackeryMod;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class HackPotions {

	public static Potion potionGitchFest;
	
	public static Potion potionGF;
	
	public static void register() {
		Potion[] potionTypes = null;
		if(Potion.potionTypes.length < 256){
			Class clazz = Potion.class;
			Field[] fields = clazz.getDeclaredFields();
			for(Field f : fields){
				if(f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")){
					try{
						Field modifiers = Field.class.getDeclaredField("modifiers");
						modifiers.setAccessible(true);
						modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
						potionTypes = (Potion[]) f.get(null);
						final Potion[] newPotionTypes = new Potion[256];
						System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
						f.set(null, newPotionTypes);
					}catch (Exception e){
						HackeryMod.logger.error("Something went wrong while making the potion array bigger..");
						e.printStackTrace();
					}
				}
			}
		}
		

		potionGF = new HackPotion(HackeryMod.config.idEffectGlitch, new ResourceLocation("glitched"), true, 0).setPotionName("GlitchFest");
	}

}
