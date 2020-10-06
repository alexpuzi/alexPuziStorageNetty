
package io.netty.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter { //(1)
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {     //(2)
        // Discard the received data silently.
        ((ByteBuf) msg).release();                                       //(3)
    }

    @Override
    // (4)
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
