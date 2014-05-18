package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.items.ExploitItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemExpBottle;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class InfectedEnchantHandler {
    @SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        if (e.entity instanceof EntityPlayerMP && ((EntityPlayerMP) e.entity).getHeldItem() instanceof ExploitItem &&)
    }
}
