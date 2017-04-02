package day10.pm2;
/**
 * 为了避免子类继承父类出现编译错误，常常为类
 * 提供“无意义”的无参数构造器！ 
 *
 */
public class Demo10 {
	public static void main(String[] args) {

	}
}
class Koo{
	//public Koo(){
	//}
	public Koo(int b){
	}
}
class Foo extends Koo{
	public Foo() {
		super(8);
	}
}



