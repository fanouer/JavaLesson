package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyListener 
	implements ServletRequestListener,
	HttpSessionAttributeListener {

	@Override
	public void requestDestroyed(
			ServletRequestEvent arg0) {
		System.out.println("request����");
	}

	@Override
	public void requestInitialized(
			ServletRequestEvent e) {
		System.out.println("request��ʼ��");
		System.out.println(e.getServletRequest());
	}

	@Override
	public void attributeAdded(
		HttpSessionBindingEvent e) {
		System.out.println(
			"��session�����������");
		System.out.println(e.getSession());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

}




