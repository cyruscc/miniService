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
	    //��дͨ����10�������κβ����������״̬
	    //2.��д������,
	    //ͨ��TextLineCodeFactory����빤�����ַ������б���봦��
	    acceptor.getFilterChain().addLast("codec",
	    		new ProtocolCodecFilter(
	    				new TextLineCodecFactory(
	    						Charset.forName("UTF-8"),
	    						LineDelimiter.WINDOWS.getValue(),
	    						LineDelimiter.WINDOWS.getValue())));
	    //�Ի��з�Ϊ��ʶ������
	    //3.ע��iohandler��ioservice
	    acceptor.setHandler(new ServiceHandler());
	    //4���׽���
	    try {
			acceptor.bind(new InetSocketAddress(9527));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
