package com.by.gameservice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MainService {

	 private static final Logger log = Logger.getLogger("MainService");  
	public static void main(String[] args) {
		IoAcceptor acceptor=new NioSocketAcceptor();
	    acceptor.getSessionConfig().setReadBufferSize(2048);
	    acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
	    //读写通道在10秒内无任何操作进入空闲状态
	    //2.编写过滤器,
	    //通过TextLineCodeFactory编解码工厂对字符串进行编解码处理
	    acceptor.getFilterChain().addLast("codec",
	    		new ProtocolCodecFilter(
	    				new TextLineCodecFactory(
	    						Charset.forName("UTF-8"),
	    						LineDelimiter.WINDOWS.getValue(),
	    						LineDelimiter.WINDOWS.getValue())));
	    //以换行符为标识的数据
	    //3.注册iohandler到ioservice
	    acceptor.setHandler(new ServiceHandler());
	    //4绑定套接字
	    try {
			acceptor.bind(new InetSocketAddress(9527));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
