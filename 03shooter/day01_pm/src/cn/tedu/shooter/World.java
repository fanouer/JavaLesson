package cn.tedu.shooter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//画框
import javax.swing.JPanel;//底板
import javax.swing.JLabel;//标签

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
			//测试图片是否读取成功！
			System.out.println(background);	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public World() {
		//一片天空
		//一个英雄
		//没有子弹，没有敌人
		sky = new Sky(background);
		hero = new Hero();
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
		g.setColor(Color.BLUE); 
		g.drawLine(0, 0, 10, 10);
		//在 0,0 位置上贴sky的图片
		g.drawImage(sky.image, 0, 0, null);
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
		
	}
}





