package day05;
import java.util.Arrays;
//求数组中的最大值
public class MaxOfArray {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		
		int max = arr[0]; //假设第1个元素为最大值
		for(int i=1;i<arr.length;i++){ //遍历剩余元素
			if(arr[i]>max){ //若大于max
				max=arr[i]; //修改max的值为较大的
			}
		}
		System.out.println("最大值为:"+max);
		
		//扩容(创建新的数组并将原数组中的数据复制进去)
		arr = Arrays.copyOf(arr,arr.length+1);
		//将最大值赋值给arr中的最后一个元素
		arr[arr.length-1] = max;
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
}











