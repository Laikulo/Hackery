package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.HackeryMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.item.ItemTossEvent;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class QuestEnchantHandler {

    @SubscribeEvent
    public void onDrop(ItemTossEvent e) {
        if(e.entity.worldObj.isRemote) return;
        if(!e.entityItem.getEntityItem().isItemEnchanted()) return;
        if(!EnchantmentHelper.getEnchantments(e.entityItem.getEntityItem()).containsKey(HackeryMod.enchantQuest.effectId)) return;
        e.setCanceled(true);
        e.player.inventory.setInventorySlotContents(e.player.inventory.getFirstEmptyStack(),e.entityItem.getEntityItem());
        e.player.inventoryContainer.detectAndSendChanges();
    }
}
