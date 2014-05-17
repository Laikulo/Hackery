package guru.haun.hackery.potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class HackPotions {

	public static Potion potionGitchFest;
	
	public static int potionGFId=210;
	public static Potion potionGF;
	
	public static void register() {
		Potion[] potionTypes = null;
		Class clazz = Potion.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			if(f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")){
				try{
					Field modifiers = clazz.getDeclaredField("modifiers");
					modifiers.setAccessible(true);
					modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}catch (Exception e){
					
				}
			}
		}
		

		potionGF = new HackPotion(potionGFId, true, 0).setPotionName("GlitchFest");
	}

}
