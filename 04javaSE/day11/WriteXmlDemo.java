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
 * 写出XML文档
 * @author Administrator
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		try {
			List<Emp> list = new ArrayList<Emp>();
			list.add(new Emp(1,"张三",25,"男",5000));
			list.add(new Emp(2,"李四",26,"女",6000));
			list.add(new Emp(3,"王五",27,"男",7000));
			list.add(new Emp(4,"赵六",28,"女",8000));
			list.add(new Emp(5,"钱七",29,"男",9000));
			
			/*
			 * 写出XML的步骤:
			 * 1:创建一个空文档对象(Document)
			 * 2:向Document对象中添加根元素
			 * 3:根据要生成的文档格式，在跟元素中添加若干级
			 *   子元素
			 * 4:创建XMLWriter
			 * 5:通过XMLWriter将Document写出成XML文档  
			 */
			//1 
			Document doc 
				= DocumentHelper.createDocument();
			
			/*
			 * 2: Document提供了添加根元素的方法
			 * Element addElement(String name)
			 * 向当前文档中添加指定名字的根元素，并以
			 * 一个Elememt实例表示刚添加的根元素，然后
			 * 将其返回，以便于使用它来继续添加子元素，
			 * 完成文档结构
			 */
			Element root = doc.addElement("list");
			
			//循环添加若干个emp标签
			for(Emp emp : list){
				/*
				 * 向跟标签中添加子标签emp
				 * Element也支持addElement方法
				 */
				Element empEle
					= root.addElement("emp");
				
				//向emp标签添加属性“id”
				empEle.addAttribute("id", emp.getId()+"");
				
				//向emp标签中添加子标签name
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
			System.out.println("写出完毕!");
					
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





