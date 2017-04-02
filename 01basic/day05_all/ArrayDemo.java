package day05;
import java.util.Arrays;
//数组的演示
public class ArrayDemo {
	public static void main(String[] args) {
		//6.数组的排序
		int[] arr = {13,45,23,5,3};
		for(int i=0;i<arr.length-1;i++){ //控制轮数
			for(int j=0;j<arr.length-1-i;j++){ //控制每轮的次数
				if(arr[j]<arr[j+1]){ //每次都和它下一个比
					int t=arr[j]; //交换两个数
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
				//若前数大于后数则交换，保证前数小于后数---升序
				//若前数小于后数则交换，保证前数大于后数---降序
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		
		
		
		
		
		
		
		
		/*
		int[] arr = {10,35,4,23,58,1};
		Arrays.sort(arr); //升序排列
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		
		/*
		//5.数组的复制
		int[] a = {10,20,30,40,50};
		//扩容(创建一个新的数组，并把原始数组中的数据复制过去了)
		a = Arrays.copyOf(a,a.length+1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		*/
		/*
		int[] a = {10,20,30,40,50};
		//a:源数组
		//a1:目标数组
		//6:目标数组的长度
		int[] a1 = Arrays.copyOf(a,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		/*
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6]; //0,0,0,0,0,0
		//a:源数组
		//1:源数组的起始下标
		//a1:目标数组
		//0:目标数组的起始下标
		//4:复制的元素的个数
		System.arraycopy(a,1,a1,0,8);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * 数组的练习:
		 * 1.声明int型数组arr，包含4个元素
		 * 2.声明int型数组arr1并直接赋值为1,5,7,8
		 *   声明int型数组arr2，
		 *     给arr2赋值为1,5,7,8
		 * 3.输出arr的长度
		 *   给arr中第1个元素赋值为100
		 *   给arr中第2个元素赋值为200
		 *   输出arr中最后一个元素的值(下标不写死)
		 *   arr[4]=200;-----------------???
		 * 4.创建类MaxOfArray，在main中:
		 *   1)声明int型数组arr，包含10个元素
		 *   2)循环方式给arr中每个元素赋值为0到99的随机数
		 *   3)循环方式输出arr中的每一个元素
		 */
		
		
		
		
		/*
		//4.数组的遍历
		int[] arr = new int[4];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		/*
		//3.数组的访问
		int[] arr = new int[3];
		arr[0] = 100; //给第一个元素赋值为100
		arr[1] = 200;
		arr[2] = 300;
		//arr[3] = 400; //数组下标越界异常ArrayIndexOutOfRangeException
		System.out.println(arr[arr.length-1]); //输出最后一个元素的值
		*/
		
		/*
		//2.数组的初始化
		int[] arr = new int[3];        //0,0,0
		int[] arr1 = {2,5,8};          //2,5,8
		int[] arr2 = new int[]{2,5,8}; //2,5,8
		int[] arr3;
		//arr3 = {2,5,8}; //编译错误，此方式只能声明同时初始化
		arr3 = new int[]{2,5,8}; //正确
		*/
		
		/*
		//1.数组的定义
		//声明int型数组arr，包含4个元素，每个元素都是int型，默认值为0
		int[] arr = new int[4];
		*/
	}
}














