package guru.haun.hackery.blocks;

import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.api.exploits.ExploitUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class TraceAnalyzerTE extends TileEntity implements IInventory {

	private ItemStack[] inv;
	private static int operationTicks = 300;
	public int operationProgress;
	private boolean running;
	
	public TraceAnalyzerTE() {
		inv = new ItemStack[2];
		this.running = false;
		this.operationProgress = 0;
	}
	
	public boolean canUpdate() {
		return true;
	}
	
	public void updateEntity() {
		//Processing Code- server side ONLY
		if(!worldObj.isRemote){
			if(this.running){
				if(!canProcess()){
					this.operationProgress = 0;
					this.running = false;
				}else{
					this.operationProgress++;
					this.markDirty();
					if(this.operationProgress >= operationTicks){
						processBlock();
						this.operationProgress = 0;
						this.running = false;
					}
				}
			}else{
				if(canProcess()){
					this.operationProgress = 0;
					this.running = true;
				}
			}
		}
	}
	
	public void processBlock(){
		inv[0].stackSize--;
		if(inv[0].stackSize <= 0)
			inv[0] = null;
		if(new Random().nextInt(3) == 0)
			inv[1] = new ItemStack(HackeryMod.itemExploit,1,ExploitUtils.pickExploit().getId());
		else if (new Random().nextBoolean())
			inv[1] = new ItemStack(HackeryMod.shardGlitch,1,0);
	}
	
	public boolean canProcess(){
		return this.inv[0] != null && this.inv[1] == null &&
				this.inv[0].getItem() == Item.getItemFromBlock(HackeryMod.blockGlitch);
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
	public String getName() {
		return "guru.haun.hackers.tracer";
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public IChatComponent getDisplayName() {
		return new ChatComponentText("Trace Analyzer");
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
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {

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

	@Override
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

	@Override
	public void openInventory(EntityPlayer playerIn) {

	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {

	}
}
