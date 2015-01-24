package guru.haun.hackery;

import guru.haun.hackery.network.IPacket;
import guru.haun.hackery.network.setBSODPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;


public class HacketHandler extends FMLIndexedMessageToMessageCodec<IPacket>{

	public static void writeString(ByteBuf buff, String string){
		if(string == null) {
			buff.writeInt(0);
		}else{
			for(int i = 0 ;i < string.length() ; i++){
				buff.writeChar(string.toCharArray()[i]);
			}
		}
	}
	
	public static String readString(ByteBuf buff){
		String string;
		int size = buff.readInt();
		string = "";
		for(int i = 0; i < size; i++){
			string += buff.readChar();
		}
		return string;
	}
	
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
