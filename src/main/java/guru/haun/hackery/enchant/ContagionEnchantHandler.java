package guru.haun.hackery.enchant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import guru.haun.hackery.HackeryMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.Random;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class ContagionEnchantHandler {
    private void action(EntityPlayer e){
        if(e.getHeldItem() == null) return;
        if(!e.getHeldItem().isItemEnchanted()) return;
        if(!(EnchantmentHelper.getEnchantments(e.getHeldItem()).containsKey(HackeryMod.enchantSpread.effectId))) return;
        InventoryPlayer inv = e.inventory;
        int theStack = new Random().nextInt(35);
        ItemStack theIStack = inv.getStackInSlot(theStack);
        if(theIStack == null) return;
        theIStack.addEnchantment(HackeryMod.enchantSpread,0);
        if(EnchantmentHelper.getEnchantments(e.getHeldItem()).containsKey(HackeryMod.enchantVirus.effectId))
            theIStack.addEnchantment(HackeryMod.enchantVirus,0);
        e.inventory.markDirty();
        e.inventoryContainer.detectAndSendChanges();
    }

    @SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        if(e.entity.worldObj.isRemote) return;
        if(e.source.getEntity() == null) return;
        if(!(e.source.getEntity() instanceof EntityPlayer)) return;
        HackeryMod.logger.error("test");
        action((EntityPlayer) e.source.getEntity());
    }

    @SubscribeEvent
    public void onUseItem(PlayerUseItemEvent e){
        if(e.entityPlayer.worldObj.isRemote) return;
        action(e.entityPlayer);
    }
}
