package guru.haun.hackery.blocks;

import guru.haun.hackery.HackeryMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TraceAnalyzerTE extends TileEntity implements IInventory {

	private ItemStack[] inv;
	private static int operationTicks = 300;
	private int operationProgress;
	private boolean running;
	
	public TraceAnalyzerTE() {
		inv = new ItemStack[2];
		// TODO THIS IS DEBUG!!!
		this.running = true;
		this.operationProgress = 0;
	}
	
	public boolean canUpdate() {
		return true;
	}
	
	public void updateEntity() {
		//Processing Code- server side ONLY
		if(worldObj.isRemote){
			if(this.running){
				if(this.operationProgress >= this.operationTicks);
			}
		}
	}
	
	public void processBlock(){
		//TODO DEBUG HERE!
		this.operationProgress = 0;
	}
	
	public int getScaledProgress(int scalar){
		return this.operationProgress * scalar / operationTicks;
	}
	
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inv[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		ItemStack stack = getStackInSlot(var1);
		if(stack != null){
			if(stack.stackSize <= var2) {
				setInventorySlotContents(var1,null);
			}else{
				stack = stack.splitStack(var2);
				if(stack.stackSize == 0) {
					setInventorySlotContents(var1,null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack stack = getStackInSlot(var1);
		if(stack != null) {
			setInventorySlotContents(var1,null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
			stack.stackSize = getInventoryStackLimit();
	}

	@Override
	public String getInventoryName() {
		return "guru.haun.hackers.tracer";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		NBTTagList taglist = nbt.getTagList("inventory",Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < taglist.tagCount(); i++){
			NBTTagCompound tag = (NBTTagCompound) (taglist.getCompoundTagAt(i));
			byte slot = tag.getByte("slot");
			if(slot >= 0 && slot < inv.length){
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		NBTTagList itemList = new NBTTagList();
		for(int i = 0; i < inv.length; i++){
			ItemStack stack = inv[i];
			if( stack != null ) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		nbt.setTag("inventory",itemList);
	}
	
	
}
