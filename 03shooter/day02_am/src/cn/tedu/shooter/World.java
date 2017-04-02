package cn.tedu.shooter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//画框
import javax.swing.JPanel;//底板
import javax.swing.JLabel;//标签

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 世界
 * 游戏的整体
 */
public class World extends JPanel{
	/** 一片天空 */
	private Sky sky;
	/** 一个英雄 */
	private Hero hero;
	/** 一群敌人 */
	private FlyingObject[] enemies;
	/** 一堆子弹，飞行中的子弹 */
	private Bullet[] bullets;
	
	/**
	 * 利用静态代码块一次性的读取静态的图片资源
	 */
	private static BufferedImage background;
	private static BufferedImage airplane;
	private static BufferedImage bigPlane;
	private static BufferedImage bee;
	private static BufferedImage heroImg;
	private static BufferedImage bullet;
	static{
		//利用静态代码块读取图片文件到图片对象
		// background.png -> background
		try{//错误处理语法，用于处理读取图片时候的意外情况
			// 导入 javax.imageio.ImageIO 类
			// ImageIO 的 read 方法将一个图片文件
			// 读取到内存中为BufferedImage类型对象
			background = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/background.png"));
			airplane = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/airplane.png"));
			bigPlane = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/bigplane.png"));
			bee = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/bee.png"));
			bullet = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/bullet.png"));
			heroImg = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/hero0.png"));

			//测试图片是否读取成功！
			System.out.println(background);	
			System.out.println(bee);	
			System.out.println(airplane);	
			System.out.println(bigPlane);	
			System.out.println(bullet);	
			System.out.println(heroImg);	
					
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public World() {
		//一片天空
		//一个英雄
		//没有子弹，没有敌人
		sky = new Sky(background);
		hero = new Hero(heroImg);
		//一个子弹对象都没有，创建了长度为0的数组
		//当出现子弹时候，数组进行扩容添加子弹
		bullets = new Bullet[0];
		enemies = new FlyingObject[0];
	}
	
	/**
	 * 利用重写修改 World（面板JPanel）
	 * 重写paint(Graphics g) 方法，重写此方法
	 * 可以实现自定义绘制（愿意画啥就画啥） 
	 * paint 涂画
	 * draw 绘画
	 * Graphics 图，画笔
	 */
	public void paint(Graphics g){
		//g.setColor(Color.BLUE); 
		//g.drawLine(0, 0, 10, 10);
		//在 0,0 位置上贴sky的图片
		//g.drawImage(sky.image, 
		//		sky.x, sky.y1, null);
		//g.drawImage(sky.image, 
		//		sky.x, sky.y2, null);
		
		//让天空对象，利用画笔g把自己画出来。
		sky.paint(g);
		hero.paint(g);
		//g.drawImage(hero.image, 20, 100, null);
	}
	
	
	/**
	 * 在World 类增加一个方法：绑定定时器任务
	 * 创建定时器任务对象（匿名内部类）可以共享
	 * 当前对象的属性了！
	 */
	private Timer timer;
	
	public void action(){
		//创建的匿名内部类，可以共享 外部类对象
		//的属性
		timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				//System.out.println("OK");
				sky.move();//修改y
				//repaint：重新绘制，重绘,repaint来自父类
				// JPanel 的方法，这个方法会尽快的执行paint
				// 方法 paint 方法绘制图片，将面板重新绘制。
				repaint();//在新y位置绘制图片
			}
		}; 
		timer.schedule(task, 0, 1000/30); 
	}
	
	public static void main(String[] args) {
		World world = new World();
		
		JFrame frame = new JFrame();//创建窗口对象
		/** 设置在关闭窗口时候，退出程序 */
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE); 
		//JPanel panel = new JPanel();//创建面板对象
		//JLabel label = new JLabel("Hello");
		//panel.add(label);//面板添加标签
		//frame.add(panel);//窗口添加面板
		frame.add(world);
		frame.setSize(480, 600);//设置大小
		frame.setVisible(true);//显示窗口 
		//Java frame 在显示的时候会自动
		// 调用paint方法
		// paint 方法被setVisible 回调
		
		world.action();//启动了定时器！
	}
}





