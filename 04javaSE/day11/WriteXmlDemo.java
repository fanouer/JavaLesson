package day11;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * д��XML�ĵ�
 * @author Administrator
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		try {
			List<Emp> list = new ArrayList<Emp>();
			list.add(new Emp(1,"����",25,"��",5000));
			list.add(new Emp(2,"����",26,"Ů",6000));
			list.add(new Emp(3,"����",27,"��",7000));
			list.add(new Emp(4,"����",28,"Ů",8000));
			list.add(new Emp(5,"Ǯ��",29,"��",9000));
			
			/*
			 * д��XML�Ĳ���:
			 * 1:����һ�����ĵ�����(Document)
			 * 2:��Document��������Ӹ�Ԫ��
			 * 3:����Ҫ���ɵ��ĵ���ʽ���ڸ�Ԫ����������ɼ�
			 *   ��Ԫ��
			 * 4:����XMLWriter
			 * 5:ͨ��XMLWriter��Documentд����XML�ĵ�  
			 */
			//1 
			Document doc 
				= DocumentHelper.createDocument();
			
			/*
			 * 2: Document�ṩ����Ӹ�Ԫ�صķ���
			 * Element addElement(String name)
			 * ��ǰ�ĵ������ָ�����ֵĸ�Ԫ�أ�����
			 * һ��Elememtʵ����ʾ����ӵĸ�Ԫ�أ�Ȼ��
			 * ���䷵�أ��Ա���ʹ���������������Ԫ�أ�
			 * ����ĵ��ṹ
			 */
			Element root = doc.addElement("list");
			
			//ѭ��������ɸ�emp��ǩ
			for(Emp emp : list){
				/*
				 * �����ǩ������ӱ�ǩemp
				 * ElementҲ֧��addElement����
				 */
				Element empEle
					= root.addElement("emp");
				
				//��emp��ǩ������ԡ�id��
				empEle.addAttribute("id", emp.getId()+"");
				
				//��emp��ǩ������ӱ�ǩname
				Element nameEle
					= empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				//age
				empEle.addElement("age")
				      .addText(emp.getAge()+"");
				
				//gender
				empEle.addElement("gender")
				      .addText(emp.getGender());
				
				//salary
				empEle.addElement("salary")
				      .addText(emp.getSalary()+"");
			}
			
			//4
			XMLWriter writer 
				= new XMLWriter(OutputFormat.createPrettyPrint());
			writer.setOutputStream(
				new FileOutputStream(
					"myemp.xml"	
				)	
			);
			
			//5
			writer.write(doc);
			System.out.println("д�����!");
					
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





