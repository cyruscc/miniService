package com.by.gameservice;

import java.util.logging.Logger;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServiceHandler extends IoHandlerAdapter {

	public static final Logger log = Logger.getLogger("ServiceHandler");

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(session, cause);
		cause.printStackTrace();
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		//super.inputClosed(session);
		System.out.println("inputClosed");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		//super.messageReceived(session, message);
		System.out.println("messageReceived:"+message);
		if(message.equals("quick")){
			session.write("quick;");
		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		//super.messageSent(session, message);
		System.out.println("messageSent:"+message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		System.out.println("sessionClosed:");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
		System.out.println("sessionIdle");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		System.out.println("sessionOpened");
	} 
	
}
