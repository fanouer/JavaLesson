package day11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author Administrator
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 步骤:
			 * 1:创建SAXReader
			 * 2:使用SAXReader读取数据源，并解析
			 *   为一个Document对象
			 * 3:根据Document对象获取根元素
			 * 4:根据文档结构，从根元素开始逐步获取
			 *   每一个节点达到解析XML文档的目的  
			 */
			//1 org.dom4j.*
			SAXReader reader = new SAXReader();
			
			
			/*
			 * 2 读取数据源
			 * DOM解析慢，就慢在这一步，耗资源也是在这里体现。
			 * 因为该方法会将整个xml文档全部读取完毕，文档内容
			 * 越多，时间越长。而且会将该文档所有内容保存到
			 * Document对象中，由于对象在内存里，所有文档内容
			 * 越多，占用内存资源越大。
			 */
			Document doc
				= reader.read(new File("emplist.xml"));
			
			/*
			 * Document对象提供了方法:
			 * Element getRootElement()
			 * 该方法可以获取当前xml文档的根元素
			 * 
			 * Element类:
			 * 每一个Element的实例都可以表示XML文档的
			 * 一个元素(一对标签)
			 * 
			 */
			Element root = doc.getRootElement();
			/*
			 * 4:根据文档结构解析XML内容
			 * Element提供了获取子元素的相关方法:
			 * 
			 * Element element(String str)
			 * 获取当前元素下指定名字的子元素
			 * 
			 * List elements(String str)
			 * 获取当前元素下所有同名子元素
			 * 
			 * List elements()
			 * 获取当前元素下的所有子元素
			 * 
			 * 
			 */
			//获取<list>根标签下的所有emp标签
			List<Element> elements 
				= root.elements();
			
			//该集合用来保存所有解析的员工
			List<Emp> list = new ArrayList<Emp>();
			
			
			for(Element empEle : elements){
//				//输出标签名
//				System.out.println(e.getName());
				
				//获取id属性的值
				Attribute attr
					= empEle.attribute("id");
				int id = Integer.parseInt(
					attr.getValue()
				);
				
				//获取名字
				Element nameEle
					= empEle.element("name");
				/*
				 * Element提供了获取中间文本信息的方法:
				 * String getText()
				 * String getTextTrim()
				 */
				String name = nameEle.getText();
				
				/*
				 * 获取年龄
				 * Element提供了方法:
				 * String elementText(String name)
				 * 获取当前元素中指定名字的子元素中间的文本
				 */
				int age = Integer.parseInt(
					empEle.elementTextTrim("age")
				);
				
				//获取性别
				String gender 
					= empEle.elementText("gender");
				//获取工资
				int salary = Integer.parseInt(
					empEle.elementTextTrim("salary")	
				);	
				
//				//打桩
//				System.out.println(name+","+age+","+gender+","+salary);
				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			System.out.println("解析完毕!");
			for(Emp e : list){
				System.out.println(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





