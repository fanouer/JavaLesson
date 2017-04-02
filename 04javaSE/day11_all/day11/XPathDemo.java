package day11;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPath查询XML文档中的内容
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
			 * 使用XPath检索内容
			 * Document提供了使用XPath方法检索数据的方法:
			 * List selectNodes(String xpath)
			 * 该方法会根据路径描述信息，获取对应数据
			 * 需要注意,返回的List集合不要使用泛型约束，
			 * 因为返回的集合中不一定都是Element实例，
			 * 还有可能是Attribute(属性)等内容。
			 * 
			 */
			//查看所有人的名字?
			String path = "/list/emp/name";
			
			//查看所有人的年龄?
			path = "/list/emp/age";
			
			//查看所有女员工的名字?
			path = "/list/emp[gender='女']/name";
			
			//查看工资高于7000的员工年龄?
			path = "/list/emp[salary>7000]/age";
			
			//查看id为4的员工的名字?
			path = "/list/emp[@id='4']/name";
			
			//查看id为>2的女员工的名字?
			path = "/list/emp[@id>2 and gender='女']/name";
			
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

