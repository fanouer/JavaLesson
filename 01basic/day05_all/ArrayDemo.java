package day05;
import java.util.Arrays;
//�������ʾ
public class ArrayDemo {
	public static void main(String[] args) {
		//6.���������
		int[] arr = {13,45,23,5,3};
		for(int i=0;i<arr.length-1;i++){ //��������
			for(int j=0;j<arr.length-1-i;j++){ //����ÿ�ֵĴ���
				if(arr[j]<arr[j+1]){ //ÿ�ζ�������һ����
					int t=arr[j]; //����������
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
				//��ǰ�����ں����򽻻�����֤ǰ��С�ں���---����
				//��ǰ��С�ں����򽻻�����֤ǰ�����ں���---����
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		
		
		
		
		
		
		
		
		/*
		int[] arr = {10,35,4,23,58,1};
		Arrays.sort(arr); //��������
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		
		/*
		//5.����ĸ���
		int[] a = {10,20,30,40,50};
		//����(����һ���µ����飬����ԭʼ�����е����ݸ��ƹ�ȥ��)
		a = Arrays.copyOf(a,a.length+1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		*/
		/*
		int[] a = {10,20,30,40,50};
		//a:Դ����
		//a1:Ŀ������
		//6:Ŀ������ĳ���
		int[] a1 = Arrays.copyOf(a,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		/*
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6]; //0,0,0,0,0,0
		//a:Դ����
		//1:Դ�������ʼ�±�
		//a1:Ŀ������
		//0:Ŀ���������ʼ�±�
		//4:���Ƶ�Ԫ�صĸ���
		System.arraycopy(a,1,a1,0,8);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * �������ϰ:
		 * 1.����int������arr������4��Ԫ��
		 * 2.����int������arr1��ֱ�Ӹ�ֵΪ1,5,7,8
		 *   ����int������arr2��
		 *     ��arr2��ֵΪ1,5,7,8
		 * 3.���arr�ĳ���
		 *   ��arr�е�1��Ԫ�ظ�ֵΪ100
		 *   ��arr�е�2��Ԫ�ظ�ֵΪ200
		 *   ���arr�����һ��Ԫ�ص�ֵ(�±겻д��)
		 *   arr[4]=200;-----------------???
		 * 4.������MaxOfArray����main��:
		 *   1)����int������arr������10��Ԫ��
		 *   2)ѭ����ʽ��arr��ÿ��Ԫ�ظ�ֵΪ0��99�������
		 *   3)ѭ����ʽ���arr�е�ÿһ��Ԫ��
		 */
		
		
		
		
		/*
		//4.����ı���
		int[] arr = new int[4];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		/*
		//3.����ķ���
		int[] arr = new int[3];
		arr[0] = 100; //����һ��Ԫ�ظ�ֵΪ100
		arr[1] = 200;
		arr[2] = 300;
		//arr[3] = 400; //�����±�Խ���쳣ArrayIndexOutOfRangeException
		System.out.println(arr[arr.length-1]); //������һ��Ԫ�ص�ֵ
		*/
		
		/*
		//2.����ĳ�ʼ��
		int[] arr = new int[3];        //0,0,0
		int[] arr1 = {2,5,8};          //2,5,8
		int[] arr2 = new int[]{2,5,8}; //2,5,8
		int[] arr3;
		//arr3 = {2,5,8}; //������󣬴˷�ʽֻ������ͬʱ��ʼ��
		arr3 = new int[]{2,5,8}; //��ȷ
		*/
		
		/*
		//1.����Ķ���
		//����int������arr������4��Ԫ�أ�ÿ��Ԫ�ض���int�ͣ�Ĭ��ֵΪ0
		int[] arr = new int[4];
		*/
	}
}














