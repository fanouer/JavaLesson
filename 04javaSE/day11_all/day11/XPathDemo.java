package day11;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��XPath��ѯXML�ĵ��е�����
 * @author Administrator
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader
				= new SAXReader();
			
			Document doc
				= reader.read(new File("myemp.xml"));
			
			/*
			 * ʹ��XPath��������
			 * Document�ṩ��ʹ��XPath�����������ݵķ���:
			 * List selectNodes(String xpath)
			 * �÷��������·��������Ϣ����ȡ��Ӧ����
			 * ��Ҫע��,���ص�List���ϲ�Ҫʹ�÷���Լ����
			 * ��Ϊ���صļ����в�һ������Elementʵ����
			 * ���п�����Attribute(����)�����ݡ�
			 * 
			 */
			//�鿴�����˵�����?
			String path = "/list/emp/name";
			
			//�鿴�����˵�����?
			path = "/list/emp/age";
			
			//�鿴����ŮԱ��������?
			path = "/list/emp[gender='Ů']/name";
			
			//�鿴���ʸ���7000��Ա������?
			path = "/list/emp[salary>7000]/age";
			
			//�鿴idΪ4��Ա��������?
			path = "/list/emp[@id='4']/name";
			
			//�鿴idΪ>2��ŮԱ��������?
			path = "/list/emp[@id>2 and gender='Ů']/name";
			
			List<Element> list 
				= doc.selectNodes(path);
			
			for(Element e : list){
				String name = e.getName();
				String text = e.getText();
				System.out.println(name+":"+text);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

