package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.HackeryMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.Random;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class InfectedEnchantHandler {
    @SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        if(e.entity.worldObj.isRemote) return;
        if(e.source.getEntity() == null) return;
        if(!(e.source.getEntity() instanceof EntityPlayer)) return;
        derpInv((EntityPlayer) e.source.getEntity());
    }

    @SubscribeEvent
    public void onUseItem(PlayerUseItemEvent.Finish e){
        if(e.entityPlayer.worldObj.isRemote) return;
        derpInv(e.entityPlayer);
    }

    private void derpInv(EntityPlayer e){
        if(e.getHeldItem() == null) return;
        if(!e.getHeldItem().isItemEnchanted()) return;
        if(!(EnchantmentHelper.getEnchantments(e.getHeldItem()).containsKey(HackeryMod.enchantVirus.effectId))) return;
        InventoryPlayer inv = e.inventory;
        int theStack = new Random().nextInt(35);
        ItemStack theIstack = inv.getStackInSlot(theStack);
        if(theIstack == null) return;
        theIstack.stackSize--;
        if(theIstack.stackSize < 1){
            e.inventory.setInventorySlotContents(theStack,null);
        }
        e.inventory.markDirty();
        e.inventoryContainer.detectAndSendChanges();
    }

}
