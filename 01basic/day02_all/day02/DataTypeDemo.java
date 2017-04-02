package day02;

//数据类型的演示
public class DataTypeDemo {
	public static void main(String[] args) {
		/*
		 * 数据类型转换的练习:
		 * 1.声明整型变量a并赋值为250
		 *   声明长整型变量b并赋值为a
		 *   声明整型变量c并赋值为b
		 * 2.声明长整型变量d并赋值为100亿
		 *   声明整型变量e并赋值为d，输出e的值
		 *   声明浮点型变量f并赋值为56.987
		 *   声明整型变量g并赋值为f，输出g的值
		 * 3.声明byte型变量b1并赋值为5
		 *   声明byte型变量b2并赋值为6
		 *   声明byte型变量b3并赋值为b1+b2，输出b3的值
		 */
		
		/*
		//基本数据类型间的转换
		//两点规则:
		//1)整数直接量可以直接赋值给byte,short,char，
		//  但不能超范围
		//2)byte,short,char型变量参与运算时，
		//  一律先转为int再运算
		byte b1=5;
		byte b2=6;
		byte b3=(byte)(b1+b2);
		
		int a=5;
		long b=a; //自动类型转换(小到大)
		int c=(int)b; //强制类型转换(大到小)
		
		long d=250; //自动类型转换
		double e=250; //自动类型转换
		
		long f=10000000000L;
		int g=(int)f;
		System.out.println(g); //溢出，强转有可能溢出
		
		double h=23.987;
		int i=(int)h;
		System.out.println(i); //23，强转有可能会精度丢失
		*/
		
		
		
		
		
		
		
		
		
		
		/*
		 * boolean、char的练习:
		 * 1.声明布尔型变量b1并赋值为true
		 *   声明布尔型变量b2并赋值为false
		 *   声明布尔型变量b3并赋值为25------???
		 * 2.声明字符型变量c1并赋值为男
		 *              c2并赋值为m
		 *              c3并赋值为6
		 *              c4并赋值为一个空格符
		 *              c5并赋值为中国----???
		 *   声明字符型变量c6并赋值为97，输出c6的值
		 *   声明字符型变量c7并赋值为单引号，输出c7的值
		 *   输出2+2的值，输出'2'+2的值，输出'2'+'2'的值
		 *  
		 */
		
		/*
		//5.char:字符型，2个字节
		char c1='女';
		char c2='f';
		char c3='5';
		char c4=' ';
		//char c5=男; //编译错误，必须放在单引号中
		//char c6=''; //编译错误，必须有字符
		//char c7='女性'; //编译错误，只能有一个字符
		char c8=65; //数值必须在0到65535之间
		System.out.println(c8); //A
		
		System.out.println(2+2); //4
		System.out.println('2'+'2'); //100('2'的码50，加上，'2'的码50)
		
		char c9='\'';
		System.out.println(c9); //'
		*/
		
		/*
		//4.boolean:布尔型，1个字节，只能存储true和false
		boolean a=true;  //true称为布尔型直接量
		boolean b=false; //false称为布尔型直接量
		//boolean c=250; //编译错误，数据类型不匹配，boolean只能是true和false
		*/
		
		
		
		
		
		
		
		
		/*
		 * int、long、double的练习:
		 * 1.声明整型变量a并赋值为250
		 *   声明整型变量b并赋值为100亿--------???
		 *   输出5/2的值，输出2/5的值
		 *   声明整型变量c并赋值为2147483647，
		 *     在c本身基础之上增1，输出c的值
		 * 2.声明长整型变量d并赋值为250L
		 *   声明长整型变量e并赋值为100亿------???
		 *   声明长整型变量f并赋值为100亿L
		 *   声明长整型变量g并赋值为10亿*2*10L，输出g
		 *   声明长整型变量h并赋值为10亿*3*10L，输出h
		 *   声明长整型变量i并赋值为10亿L*3*10，输出i
		 *   声明长整型变量time并赋值为
		 *     System.currentTimeMillis()，输出time
		 * 3.声明浮点型变量j并赋值为5.678
		 *   声明浮点型变量k,l，并分别赋值为3.0和2.9
		 *     输出k-l的值
		 */
		
		/*
		//3.double:浮点型，8个字节
		double a=3.14159; //3.14159为浮点型直接量，默认为double型
		float b=3.14159F; //表示float则数字后加f或F
		
		double c=6.0;
		double d=4.9;
		System.out.println(c-d); //0.100000000009，舍入误差，精确运算场合不可使用
		*/
		
		/*
		//2.long:长整型，8个字节，很大很大很大
		long a=250L; //250L为长整型直接量
		//long b=10000000000; //编译错误，100亿为int型，但超范围了
		long c=10000000000L;
		
		long d=1000000000*2*10L;
		System.out.println(d); //200亿
		long e=1000000000*3*10L;
		System.out.println(e); //溢出了
		long f=1000000000L*3*10;
		System.out.println(f); //300亿
		
		//获取自1970.1.1零时到此时此刻的毫秒数
		long g=System.currentTimeMillis();
		System.out.println(g);
		*/
		
		/*
		//1.int:整型，4个字节，-21个多亿到21个多亿
		int a=250; //250为整数直接量，默认int型
		//int b=10000000000; //编译错误，100亿默认为int型，但是超范围了
		
		//两个整数相除，结果还是整数
		System.out.println(5/2); //2，小数位被舍弃了
		System.out.println(2/8); //0，小数位被舍弃了
		
		int c=2147483647; //int的最大值
		c=c+1;
		System.out.println(c); //-2147483648，溢出了，需要避免
		
		//int d=10000000000;   //直接量超范围为编译错误
		int e=1000000000*10; //运算时超范围为溢出
		*/
	}
}



















