package guru.haun.hackery.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TraceAnalyzerContainer extends Container {

	protected TraceAnalyzerTE te;

	public TraceAnalyzerContainer(InventoryPlayer playerInv, TraceAnalyzerTE te){
		this.te = te;
		
			addSlotToContainer(new Slot(te,0,56,35));
			addSlotToContainer(new Slot(te,1,116,35));
			bindPlayerInventory(playerInv);
	}
	
	protected void bindPlayerInventory(InventoryPlayer playerInv) {
		for(int i = 0; o < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(playerInv, j+i*9+9, 8+j*18, 84 + i* 18)); //Main Inventory
			}
		}
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(playerInv, i, 8+i*18,142));
		}
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotobj = (Slot) inventorySlots.get(slot);
		
		if(slotobj != null && slotobj.getHasStack()) {
			ItemStack stackInSlot = slotobj.getStack();
		}
	}

}
