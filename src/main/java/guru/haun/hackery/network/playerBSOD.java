package guru.haun.hackery.network;

import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import guru.haun.hackery.HackeryMod;
import io.netty.buffer.ByteBuf;

public class playerBSOD implements IPacket {
	
	private String attacker;
	private String recipient;
	@Override
	public void readBytes(ByteBuf bytes) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void writeBytes(ByteBuf bytes) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postProcess() {
		HackeryMod.channel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
	
	}

}
