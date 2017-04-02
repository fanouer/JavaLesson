package day04;
//while循环的演示
public class WhileDemo {
	public static void main(String[] args) {
		//输出9的乘法表 4*9=36
		int num=1;     //1.
		while(num<=9){ //2.
			System.out.println(num+"*9="+num*9);
			num++;     //3.
		}
		System.out.println("over");
		
		/*
		//输出10次"行动是成功的阶梯"
		int times=0;     //1.循环变量的初始化
		while(times<10){ //2.循环的条件
			System.out.println("行动是成功的阶梯");
			times++;     //3.循环变量的改变
		}
		System.out.println("over");
		*/
		/*
		 * 执行过程:
		 * times=0 true 输出
		 * times=1 true 输出
		 * times=2 true 输出
		 * times=3 true 输出
		 * times=4 true 输出
		 * times=5 true 输出
		 * times=6 true 输出
		 * times=7 true 输出
		 * times=8 true 输出
		 * times=9 true 输出
		 * times=10 false while循环结束
		 * 输出over
		 */
	}
}


















