package day05;
/**
 * 使用当前类来重写hashcode与equals方法
 * 当一个类作为HashMap中的key使用时，就应当妥善的
 * 重写equals方法与hashcode。
 * 这两个方法的结果影响HashMap的检索性能。
 * 
 * HashMap也称为散列表
 * 
 * 重写准则：
 * 1:当我们重写一个类的equals方法时就应当连同
 *   重写hashcode方法
 * 2:hashcode应当与equals方法对应，即：
 *   当两个对象equals方法比较结果为true时，hashcode
 *   方法返回的值应当相等。
 *   反过来虽然不是必须的，但是应当尽量保证两个hashcode
 *   值相等的对象equals比较也为true,因为若为false,
 *   会在HashMap中产生链表，影响查询性能。
 * 3:hashcode返回的数字应当是一个稳定的值，即:
 *   当参与equals方法比较的属性的值没有发生改变的前提
 *   下多次调用hashcode方法返回的数字应当一样。  
 * 
 * @author Administrator
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}









