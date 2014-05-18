package guru.haun.hackery.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class ContagionEnchant extends Enchantment {

    protected ContagionEnchant(int par1, int par2, EnumEnchantmentType par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
        setName("contagion");

    }

    public int getMaxLevel() {return 1;}

    public int getMinEnchantability(int level) {
        return 100;
    }
}
