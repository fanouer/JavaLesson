package day12.am;

public class Demo05 {
	public static void main(String[] args) {
		Point p1 = new Point(0,3);
		Point p2 = new Point(4,0);
		double d = Point.distance(p1, p2);
		System.out.println(d);
		/*
		 * 调用 对象方法(非静态方法)时候调用方法
		 * 的对象引用，隐含传递给变量this
		 */
		double z = p1.distance(p2);
		System.out.println(z); 
	}
}
class Point{
    int x;
    int y;
    
    public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
    /*
     * 如果一个方法的计算过程没有用到
       当前对象(this)的数据，就可以定义为
       静态方法了！
     */
	public static double 
         distance(Point p1, Point p2){
       int a = p1.y - p2.y;
       int b = p1.x - p2.x;
       double c = Math.sqrt(a*a+b*b);
       return c;
    }
	/*
	 * 调用方法： p1.distance(p2)
	 * 
	 */
	public double distance(Point other){
		//方法在运行期间有两组数据:this other
		int a = this.y - other.y;
		int b = this.x - other.x;
		double c = Math.sqrt(a*a + b*b);
		return c;
	}
}






