package day11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ĵ�
 * @author Administrator
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		try {
			/*
			 * ����:
			 * 1:����SAXReader
			 * 2:ʹ��SAXReader��ȡ����Դ��������
			 *   Ϊһ��Document����
			 * 3:����Document�����ȡ��Ԫ��
			 * 4:�����ĵ��ṹ���Ӹ�Ԫ�ؿ�ʼ�𲽻�ȡ
			 *   ÿһ���ڵ�ﵽ����XML�ĵ���Ŀ��  
			 */
			//1 org.dom4j.*
			SAXReader reader = new SAXReader();
			
			
			/*
			 * 2 ��ȡ����Դ
			 * DOM����������������һ��������ԴҲ�����������֡�
			 * ��Ϊ�÷����Ὣ����xml�ĵ�ȫ����ȡ��ϣ��ĵ�����
			 * Խ�࣬ʱ��Խ�������һὫ���ĵ��������ݱ��浽
			 * Document�����У����ڶ������ڴ�������ĵ�����
			 * Խ�࣬ռ���ڴ���ԴԽ��
			 */
			Document doc
				= reader.read(new File("emplist.xml"));
			
			/*
			 * Document�����ṩ�˷���:
			 * Element getRootElement()
			 * �÷������Ի�ȡ��ǰxml�ĵ��ĸ�Ԫ��
			 * 
			 * Element��:
			 * ÿһ��Element��ʵ�������Ա�ʾXML�ĵ���
			 * һ��Ԫ��(һ�Ա�ǩ)
			 * 
			 */
			Element root = doc.getRootElement();
			/*
			 * 4:�����ĵ��ṹ����XML����
			 * Element�ṩ�˻�ȡ��Ԫ�ص���ط���:
			 * 
			 * Element element(String str)
			 * ��ȡ��ǰԪ����ָ�����ֵ���Ԫ��
			 * 
			 * List elements(String str)
			 * ��ȡ��ǰԪ��������ͬ����Ԫ��
			 * 
			 * List elements()
			 * ��ȡ��ǰԪ���µ�������Ԫ��
			 * 
			 * 
			 */
			//��ȡ<list>����ǩ�µ�����emp��ǩ
			List<Element> elements 
				= root.elements();
			
			//�ü��������������н�����Ա��
			List<Emp> list = new ArrayList<Emp>();
			
			
			for(Element empEle : elements){
//				//�����ǩ��
//				System.out.println(e.getName());
				
				//��ȡid���Ե�ֵ
				Attribute attr
					= empEle.attribute("id");
				int id = Integer.parseInt(
					attr.getValue()
				);
				
				//��ȡ����
				Element nameEle
					= empEle.element("name");
				/*
				 * Element�ṩ�˻�ȡ�м��ı���Ϣ�ķ���:
				 * String getText()
				 * String getTextTrim()
				 */
				String name = nameEle.getText();
				
				/*
				 * ��ȡ����
				 * Element�ṩ�˷���:
				 * String elementText(String name)
				 * ��ȡ��ǰԪ����ָ�����ֵ���Ԫ���м���ı�
				 */
				int age = Integer.parseInt(
					empEle.elementTextTrim("age")
				);
				
				//��ȡ�Ա�
				String gender 
					= empEle.elementText("gender");
				//��ȡ����
				int salary = Integer.parseInt(
					empEle.elementTextTrim("salary")	
				);	
				
//				//��׮
//				System.out.println(name+","+age+","+gender+","+salary);
				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			System.out.println("�������!");
			for(Emp e : list){
				System.out.println(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





