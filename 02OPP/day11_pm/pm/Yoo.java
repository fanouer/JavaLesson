package day11.pm;

import day11.Xoo;

public class Yoo extends Xoo{
	public void test(){
		/*
		 * 在子类中可以访问父类中定义
		 * 的保护(protected)属性
		 */
		System.out.println(a);
	}
}
