package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.ExploitUtils;
import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.exploits.IExploit;
import guru.haun.hackery.exploits.InfectionExploit;
import guru.haun.hackery.items.ExploitItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class InfectedEnchantHandler {
    @SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        if(e.entity.worldObj.isRemote) return;
        if(e.source.getEntity() == null) return;
        if(!(e.source.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer attacker = (EntityPlayer) e.source.getEntity();
        if(attacker.getHeldItem() == null) return;
        if(!attacker.getHeldItem().isItemEnchanted());
        if(!(EnchantmentHelper.getEnchantments(attacker.getHeldItem()).containsKey(HackeryMod.enchantVirus.effectId))) return;
        InventoryPlayer inv = attacker.inventory;
        

    }
}
