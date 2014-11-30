package guru.haun.hackery.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class InfectedEnchant extends Enchantment {

    public InfectedEnchant(int p_i45771_1_, ResourceLocation p_i45771_2_, int p_i45771_3_, EnumEnchantmentType p_i45771_4_) {
        super(p_i45771_1_, p_i45771_2_, p_i45771_3_, p_i45771_4_);
        setName("infected");
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int level){
        return 100; //No enchanting!
    }
}
