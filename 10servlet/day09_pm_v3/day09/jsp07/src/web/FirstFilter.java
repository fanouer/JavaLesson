package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

	//�������ر�ʱ�Զ����ø÷���������Filter
	@Override
	public void destroy() {
		System.out.println("Fisrt����");
	}

	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response,
		FilterChain chain) 
		throws IOException, ServletException {
		System.out.println("Firstǰǰǰ");
		
		//�������������о��ԵĴ���Ȩ��
		//������chain.doFilter()ʱ���������
		//�������ø÷���ʱ���������
		//һ����������ж��Filter���й��ˣ�
		//���ǰ����Ⱥ�˳�����ε��ã����κ�
		//һ��Filter�ܾ��������������
		//Filter��Servlet�����ᱻ���á�
		//���ֵ��ù�ϵ��һ�����������
		//����Ϊ������(FilterChain)��
		chain.doFilter(request, response);
		
		System.out.println("First����");
	}

	//Filter�ĳ�ʼ�����������������Filter
	//Ԥ��һЩ���ݣ��ɷ������Զ����á�
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("First��ʼ��");
	}

}
