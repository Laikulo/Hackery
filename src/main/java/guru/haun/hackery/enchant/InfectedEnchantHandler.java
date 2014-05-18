package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.ExploitUtils;
import guru.haun.hackery.exploits.IExploit;
import guru.haun.hackery.exploits.InfectionExploit;
import guru.haun.hackery.items.ExploitItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class InfectedEnchantHandler {
    @SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        if (!(e.entity instanceof EntityPlayerMP)) return;
        ItemStack is = ((EntityPlayerMP) e.entity).getHeldItem();
        if (is == null) return;
        if (is.getItem() == null) return;
        if (!(is.getItem() instanceof ExploitItem)) return;
        if (ExploitUtils.getExploitById(is.getItemDamage()).getName() != "exploitVirus") return;
        e.
    }
}
