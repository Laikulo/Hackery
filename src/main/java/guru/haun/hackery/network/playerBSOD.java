package guru.haun.hackery.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.relauncher.Side;
import guru.haun.hackery.HackeryMod;
import guru.haun.hackery.HacketHandler;
import io.netty.buffer.ByteBuf;

public class playerBSOD implements IPacket {
	
	private String attacker;
	private String recipient;
	@Override
	public void readBytes(ByteBuf bytes) {
		attacker = HacketHandler.readString(bytes);
		recipient = HacketHandler.readString(bytes);
	}
	@Override
	public void writeBytes(ByteBuf bytes) {
		HacketHandler.writeString(bytes, attacker);
		HacketHandler.writeString(bytes, recipient);
		
	}
	@Override
	public void postProcess() {
		EntityPlayerMP atk = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(attacker);
		EntityPlayerMP vic = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(recipient);
		HackeryMod.channel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		HackeryMod.channel.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(atk);
		HackeryMod.channel.get(Side.SERVER).writeOutbound(new setBSODPacket(true));
	
	}

}
