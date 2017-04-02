package day12.am;

import day12.Demo01;
/*
 * Point 是默认访问限制，只能在同包内访问
 * Point 称为 同包类！不能跨包访问！
 * 所以如下代码出现编译错误！
 */
//import day12.Point;

public class Demo02 {
	public static void main(String[] args) {
		Demo01 a;
	}
}
