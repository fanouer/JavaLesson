package day04;
//for的演示
public class ForDemo {
	public static void main(String[] args) {
		int sum=0;
		for(int num=1;num<=100;num++){
			if(num%10!=3){
				sum+=num;
			}
		}
		System.out.println("sum="+sum);
		
		
		
		/*
		int sum=0;
		for(int num=1;num<=100;num++){
			if(num%10==3){
				continue;
			}
			sum+=num; 
		}
		System.out.println("sum="+sum);
		*/
		/*
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3
		 * num=4 sum=1+2+4
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int sum=0;
		int num=1;
		for(;num<=100;num++){
			sum+=num; 
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum=0; 
		for(int num=1;num<=100;){
			sum+=num; 
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		for(;;){ //死循环
			System.out.println("我要学习...");
		}
		*/
		
		/*
		for(int i=0,j=6;i<6;i+=2,j-=2){
		}
		*/
		/*
		 * i=0,j=6
		 * i=2,j=4
		 * i=4,j=2
		 * i=6,j=0
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//累加:1+2+3+4+...+99+100=?
		int sum=0; //和
		for(int num=1;num<=100;num++){
			sum+=num; //在本身基础之上加
		}
		System.out.println("sum="+sum);
		*/
		/*
		 *       sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * num=5 sum=1+2+3+4+5
		 */
		
		
		
		
		
		
		/*
		for(int times=0;times<10;times++){
			System.out.println("行动是成功的阶梯");
		}
		System.out.println("over");
		
		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
		*/
	}
}











