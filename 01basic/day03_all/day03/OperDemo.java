package day03;
//���������ʾ
public class OperDemo {
	public static void main(String[] args){
		/*
		 * 6.����/��Ŀ�����:
		 *   1)�﷨:
		 *       boolean?��1:��2
		 *   2)ִ�й���:
		 *       ����boolean��ֵ:
		 *         ��Ϊtrue�����������ʽ�Ľ��Ϊ��1
		 *         ��Ϊfalse�����������ʽ�Ľ��Ϊ��2
		 */
		/*
		int a=55,b=8;
		int max=a>b?a:b;
		System.out.println("max="+max); //max=8
		*/
		
		
		/*
		 * 5.�ַ������������
		 *   1)+:
		 *     1.1)�����������֣������ӷ�����
		 *     1.2)����һ��Ϊ�ַ����������ַ�������
		 */
		
		/*
		System.out.println(10+20+""+30); //"3030"
		System.out.println(10+20+30+""); //"60"
		System.out.println(""+10+20+30); //"102030"
		
		int age=37;
		System.out.println("age="); //age=���ַ���ԭ�����
		System.out.println(age); //37
		System.out.println("age="+age); //age=37
		System.out.println("�ҵ�������:"+age);
		System.out.println("�ҽ���"+age+"����");
		*/
		
		/*
		 * 4.��ֵ�����
		 *   1)�򵥸�ֵ�����:=
		 *   2)��չ��ֵ�����:+=,-=,*=,/=,%=
		 */
		/*
		int a=5;
		a+=10; //�൱��a=a+10
		System.out.println(a); //15
		a*=2; //�൱��a=a*2
		System.out.println(a); //30
		a/=6; //�൱��a=a/6
		System.out.println(a); //5
		*/
		
		
		/*
		 * 3.�߼������
		 *   1)&&:��·��(����)�����߶�Ϊ����Ϊ�棬��false��false
		 *        ��һ����Ϊfalseʱ��������·(����Ĳ�ִ����)
		 *     ||:��·��(����)����һ��Ϊ����Ϊ�棬��true��true
		 *        ��һ����Ϊtrueʱ��������·(����Ĳ�ִ����)
		 *     ! :�߼���(ȡ��)��������٣��Ǽ�����
		 *   2)�߼������ǽ����ڹ�ϵ����Ļ���֮�ϵ�
		 *     �߼�����Ľ��Ҳ��boolean��
		 */
		/*
		int a=5,b=10,c=5;
		
		boolean b4=a<b || c++>2;
		System.out.println(b4); //true
		System.out.println(c);  //5��������·��
		boolean b3=a>b && c++>2;
		System.out.println(b3); //false
		System.out.println(c);  //5��������·��
		
		boolean b2=!(a>b);
		System.out.println(b2);      //!false=true
		System.out.println(!(a==c)); //!true=false
		
		System.out.println(a>b || c<b);   //false||true=true
		System.out.println(a==c || b<a);  //true||false=true
		System.out.println(a<=b || b!=c); //true||true=true
		System.out.println(a>=b || b<c);  //false||false=false
		
		boolean b1=a>b && c<b;
		System.out.println(b1);           //false&&true=false
		System.out.println(a==c && b<a);  //true&&false=false
		System.out.println(a>=b && b<c);  //false&&false=false
		System.out.println(a<=b && b!=c); //true&&true=true
		*/
		
		
		/*
		 * 2.��ϵ�����:
		 *   1)>(����),<(С��)
		 *     >=(���ڻ����),<=(С�ڻ����)
		 *     ==(����),!=(������)
		 *   2)��ϵ����Ľ��Ϊboolean��
		 *     ��ϵ������Ϊtrue����ϵ��������Ϊfalse
		 */
		/*
		int a=5,b=10,c=5;
		boolean b1=a>b;
		System.out.println(b1);   //false
		System.out.println(c<b);  //true
		System.out.println(a>=c); //true
		System.out.println(a<=c); //true
		System.out.println(a==b); //false
		System.out.println(a!=c); //false
		*/
		
		
		/*
		 * 1.���������:+,-,*,/,%,++,--
		 *   1)%:ȡģ/ȡ�࣬����Ϊ0��Ϊ����
		 *   2)++/--:����1/�Լ�1������д�ڱ���ǰҲ����д�ڱ�����
		 *     2.1)����ʹ��ʱ����ǰ�ں��޲��
		 *     2.2)��ʹ��ʱ����ǰ�ں��в��
		 *           a++��ֵΪa��ֵ
		 *           ++a��ֵΪa+1��ֵ
		 */
		/*
		int a=5,b=5;
		System.out.println(a++); //5
		System.out.println(a);   //6
		System.out.println(++b); //6
		System.out.println(b);   //6
		*/
		
		/*
		int a=5,b=5;
		int c=a++; //a++��ֵΪ5����5��ֵ��c
		int d=++b; //++b��ֵΪ6����6��ֵ��d
		System.out.println(a); //6
		System.out.println(b); //6
		System.out.println(c); //5
		System.out.println(d); //6
		*/
		
		/*
		int a=5,b=5;
		++a; //�൱��a=a+1
		b++; //�൱��b=b+1
		System.out.println(a); //6
		System.out.println(b); //6
		*/
		
		
		
		
		
		/*
		System.out.println(5%2); //1����2��1
		System.out.println(8%2); //0����4��0--����
		System.out.println(2%8); //2����0��2
		System.out.println(8.426%2); //0.426
		*/
		
	}
}















