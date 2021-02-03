package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

/**
 * ClassName: J02_TcpServer
 * Description: 所有TCP连接共用一个ChannelHandler实例
 * Date: 2021年02月03日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J02_TcpServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        private TcpServerHandler2 tcpServerHandler = new TcpServerHandler2();

                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new LineBasedFrameDecoder(80));
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(tcpServerHandler); // 多个连接使用同一个ChannelHandler实例
                        }
                    });
            ChannelFuture f = b.bind(8080).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}

// 多个连接使用同一个ChannelHandler，要加上@Sharable注解
@ChannelHandler.Sharable
class TcpServerHandler2 extends ChannelInboundHandlerAdapter {

    private AttributeKey<Integer> attributeKey = AttributeKey.valueOf("counter");

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        Attribute<Integer> attribute = ctx.attr(attributeKey);

        int counter = 1;

        if (attribute.get() == null) {
            attribute.set(1);
        } else {
            counter = attribute.get();
            counter++;
            attribute.set(counter);
        }

        String line = (String) msg;
        System.out.println("第" + counter + "次请求:" + line);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}