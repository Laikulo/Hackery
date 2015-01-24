package guru.haun.hackery.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class ContagionEnchant extends Enchantment {

    public ContagionEnchant(int p_i45771_1_, ResourceLocation p_i45771_2_, int p_i45771_3_, EnumEnchantmentType p_i45771_4_) {
        super(p_i45771_1_, p_i45771_2_, p_i45771_3_, p_i45771_4_);
        setName("contagion");
    }

    public int getMaxLevel() {return 1;}

    public int getMinEnchantability(int level) {
        return 100;
    }
}
