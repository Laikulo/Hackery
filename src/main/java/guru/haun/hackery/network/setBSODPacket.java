package guru.haun.hackery.network;

import guru.haun.hackery.HackeryMod;
import io.netty.buffer.ByteBuf;

public class setBSODPacket implements IPacket {
	private boolean state;
	 
	public setBSODPacket() {
		this.state = false;
	};
	public setBSODPacket(boolean state) {
		this.state = state;
	}
	
	public void readBytes(ByteBuf bytes)
	{
		this.state = bytes.readBoolean(); 
	}
	
	public void writeBytes(ByteBuf bytes){
		bytes.writeBoolean(state);
	}
	
	public void postProcess(){
		HackeryMod.proxy.setBSODState(state);
	}
}
