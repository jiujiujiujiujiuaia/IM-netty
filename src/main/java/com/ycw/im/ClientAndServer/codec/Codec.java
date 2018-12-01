package com.ycw.im.ClientAndServer.codec;

import com.ycw.im.ClientAndServer.protocol.Packet;
import com.ycw.im.ClientAndServer.protocol.request.LoginRequest;
import com.ycw.im.ClientAndServer.protocol.request.MessageRequest;
import com.ycw.im.ClientAndServer.protocol.response.LoginResponse;
import com.ycw.im.ClientAndServer.protocol.response.MessageResponse;
import com.ycw.im.ClientAndServer.protocol.serializer.JSONSerializer;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;

public class Codec {
    private final int MAGIC_NUMBER = 0x12345678;
    public static final Codec INSTANCE = new Codec();
    private JSONSerializer serializer = new JSONSerializer();
    private final HashMap<Integer,Class<? extends Packet>> map = new HashMap<>();

    public Codec(){
        map.put(1,LoginRequest.class);
        map.put(2,LoginResponse.class);
        map.put(3,MessageRequest.class);
        map.put(4,MessageResponse.class);
    }

    public void encode(ByteBuf byteBuf, Packet packet){
        byte[] bytes = serializer.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeInt((Integer)packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public Packet decode(ByteBuf byteBuf){
        if(byteBuf.readInt() == 0x12345678){
            int command = byteBuf.readInt();
            int length = byteBuf.readInt();
            byte[] bytes = new byte[length];
            byteBuf.readBytes(bytes);
            if(map.keySet().contains(command)){
                return serializer.deserialize(map.get(command),bytes);
            }
        }
        return  null;
    }
}
