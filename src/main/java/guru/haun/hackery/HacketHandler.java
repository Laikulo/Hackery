package guru.haun.hackery;

import guru.haun.hackery.network.IPacket;
import guru.haun.hackery.network.setBSODPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;


public class HacketHandler extends FMLIndexedMessageToMessageCodec<IPacket>{

	public HacketHandler()
	{
		addDiscriminator(0, setBSODPacket.class);
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, IPacket msg,
			ByteBuf target) throws Exception {
		msg.writeBytes(target);
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf source,
			IPacket msg) {
		msg.readBytes(source);
		msg.postProcess();
		
	}
}
