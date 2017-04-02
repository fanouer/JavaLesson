package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//画框
import javax.swing.JPanel;//底板
//标签

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
	
	private int state;
	private static final int READY=0;
	private static final int RUNNING=1;
	private static final int PAUSE=2;
	private static final int GAME_OVER=3;
	
	
	/**
	 * 利用静态代码块一次性的读取静态的图片资源
	 */
	private static BufferedImage background;
	private static BufferedImage airplane;
	private static BufferedImage bigPlane;
	private static BufferedImage bee;
	private static BufferedImage heroImg;
	private static BufferedImage bullet;
	private static BufferedImage start;
	private static BufferedImage pause;
	private static BufferedImage gameOver;
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
			start = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/start.png"));
			pause = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/pause.png"));
			gameOver = ImageIO.read(
					World.class.getClassLoader()
					.getResource(
					"cn/tedu/shooter/gameover.png"));

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
		
		state = READY;
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
		//让天空对象，利用画笔g把自己画出来。
		sky.paint(g);
		hero.paint(g);
		for(int i=0;i<bullets.length;i++){
			bullets[i].paint(g); 
		}
		for (int i = 0; 
			i < enemies.length; i++) {
			enemies[i].paint(g);
 		}
		g.drawString(
			"SCORE:"+hero.getScore(), 10, 30);
		g.drawString(
			"LIFE:"+hero.life, 10, 50);
		
		switch (state) {
		case READY:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameOver, 0, 0, null);
			break;
		}
	
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
				sky.move();
				if(state==RUNNING){
					for(int i=0;i<bullets.length;i++){
						bullets[i].move();
					}
					for (int i= 0; 
							i<enemies.length; i++){
						enemies[i].move();
					}
					shoot();
					//飞机定时入场
					planeEnter();
				}
				
				//检查飞机和子弹是否发生碰撞
				duangDuang();
				
				//检查英雄是否与某架飞机发生碰撞
				heroDuang();
				
				//检查已经出界的飞机
				checkOutOfBoundsPlane();
				//销毁无用的飞机
				destroyPlanes();
				//清理出界的对象
				clearObjects();
				
				repaint();//在新y位置绘制图片
			}

		}; 
		timer.schedule(task, 0, 1000/30); 
		
		//在action方法中添加一个监听鼠标位置的监听器
		// 这个位置添加的内部类，可以方便的共享
		// 外部类World的对象数据。
		//检查鼠标的位置
		MouseAdapter l =
				new MouseAdapter(){
			//当鼠标在面板上移动时候会执行这个方法
			//重写 mouseMoved 方法
			public void mouseMoved(
					MouseEvent e) {
				//System.out.println("Test");
				if(state==RUNNING){
					//获取鼠标当前的位置，改写hero的位置
					int x = e.getX();
					int y = e.getY();
					hero.move(x, y); 
				}
			}
			/**
			 * 鼠标离开时候执行的方法
			 */
			public void mouseExited(
					MouseEvent e) {
				 if(state==RUNNING){
					 state = PAUSE;
				 }
			}
			/**
			 * 鼠标进入时候执行
			 */
			public void mouseEntered(
					MouseEvent e) {
				if(state==PAUSE){
					state = RUNNING;
				}
			}			
			/**
			 * 鼠标单击时候执行的方法
			 */
			public void mouseClicked(
					MouseEvent e) {
				if(state==READY){
					state = RUNNING;
				}
				if(state == GAME_OVER){
					enemies = new FlyingObject[0];
					bullets = new Bullet[0];
					hero=new Hero(heroImg);
					
					state = READY;
				}
			}
		};
		//将鼠标事件监听对象l，绑定到当前面板
		//上，监听当前面板的鼠标运动情况！
		this.addMouseMotionListener(l); 
		//如果需要监听鼠标单击事件必须绑定鼠标事件
		this.addMouseListener(l); 
	}
	
	/**
	 * 在World类中添加方法 
	 */
	private void heroDuang() {
		FlyingObject obj = shootBy(hero);
		if(obj!=null){
			obj.destory();
			hero.subtractLife();
			if(! hero.isActive()){
				System.out.println("结束");
				if(state == RUNNING){
					state=GAME_OVER;
				}
			}
		}
	}
	
	/**
	 * 在World类中添加碰撞检查方法
	 */
	private void duangDuang(){
		for(int i=0; i<bullets.length;i++){
			Bullet b = bullets[i];
			FlyingObject obj = shootBy(b);
			if(obj!=null){
				b.destory();
				//子弹b击中了一个飞行物obj
				obj.subtractLife();
				if(! obj.isActive()){
					//getScore() getAward()
					if(obj instanceof Enemy){
						Enemy e = (Enemy)obj;
						int n = e.getScore();
						//System.out.println("得分:"+n);
						hero.add(n); 
					}
					if(obj instanceof Award){
						Award a = (Award)obj;
						int n = a.getAward();
						//System.out.println("奖品:"+n); 
						switch(n){
						case Award.DOUBLE_FIRE:
							hero.setDoubleFire(true);
							break;
						case Award.LIFE:
							hero.addLife(1);
							break;
						case Award.DOUBLE_LIFE:
							hero.addLife(2);
							break;
						}
					}
				}
			}
		}
	}
	/**
	 * 检查子弹b打到那架飞机，如果返回null
	 * 表示没有打到飞机，返回对象，表示打到一个飞机 
	 */
	private FlyingObject shootBy(
			FlyingObject b){
		if(! b.isActive()){
			return null;
		}
		for(int i=0; i<enemies.length;i++){
			if(enemies[i].isActive() 
				&& enemies[i].duang(b)){
				return enemies[i];
			}
		}
		return null;
	}
	
	/**
	 * 在 World 类中添加，检查飞机出界的算法
	 * 飞机出界后，立即设置 life=0
	 */
	private void checkOutOfBoundsPlane(){
		for(int i=0; i<enemies.length;
				i++){
			if(enemies[i].outOfBounds()){
				enemies[i].destory();
			}
		}
	}
	/**
	 * 销毁没有生命的飞机
	 */
	private void destroyPlanes(){
		FlyingObject[] temp={};
		for(int i=0; i<enemies.length; i++){
			if(enemies[i].isActive()){
				temp = Arrays.copyOf(
					temp, temp.length+1);
				temp[temp.length-1]=enemies[i];
			}
		}
		enemies = temp;
		System.out.println(enemies.length); 
	}
	
	/**
	 * 在World 类中添加 飞机定时出场的算法
	 */
	public void planeEnter(){
		if(index%20==0){
			int n = (int)(Math.random()*15);
			FlyingObject plane=null;
			if(n<=1){
				plane = new BigPlane(bigPlane);
			}else if(n<=2){
				plane = new Bee(bee);
			}else{
				plane = new Airplane(airplane);
			}
			//如何调试：输出飞机的数据！
			enemies = Arrays.copyOf(
				enemies, enemies.length+1);
			enemies[enemies.length-1]=plane;
		}
	}
	 
	
	/**
	 * 在World 类中 添加一个清理出界对象的方法  
	 */
	private void clearObjects(){
		//找到每个子弹对象，检查是否出界了
		//如果出界就从数组中删掉。
		Bullet[] temp={};
		for(int i=0;i<bullets.length;i++){
			if(bullets[i].outOfBounds()
				|| ! bullets[i].isActive()){
				continue;
			}
			temp = Arrays.copyOf(
					temp, temp.length+1);
			temp[temp.length-1]=bullets[i];
		}
		bullets = temp;
		//System.out.println(bullets.length); 
	}
	
	/**
	 * 在World类中添加射击算法，World 对象中
	 * 包含英雄飞机的位置， 包含子弹数组。
	 * 根据英雄位置，创建子弹对象，添加子弹数组 
	 */
	private int index=0;
	public void shoot(){
		index++;
		if(index%6 ==0){
			//间隔6次执行一次
			int x =(int)( hero.x+hero.width/2-
					bullet.getWidth()/2);
			int y =(int)(hero.y-
					bullet.getHeight());
			if(hero.isDoubleFire()){
				Bullet b1 = 
					new Bullet(x-28, y, bullet);
				Bullet b2 = 
					new Bullet(x+28, y, bullet);
				bullets = Arrays.copyOf(
						bullets, bullets.length+2);
				bullets[bullets.length-1]=b1;
				bullets[bullets.length-2]=b2;
			}else{
				Bullet b = 
					new Bullet(x, y, bullet);
				bullets = Arrays.copyOf(
						bullets, bullets.length+1);
				bullets[bullets.length-1]=b;
			}
		}
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
	
	/**
	 * 在World 类中添加测试方法
	 */
	public void testDuang(){
		Airplane plane = 
				new Airplane(airplane, 55, 74);
		Bullet b = new Bullet(60, 95, bullet);
		boolean t = plane.duang(b);
		System.out.println(t);  
	}
	public void testShootBy(){
		Airplane p1 = 
			new Airplane(airplane, 55, 74);
		Airplane p2 = 
			new Airplane(airplane, 255, 174);
		Bullet b = new Bullet(60, 95, bullet);
		enemies=new FlyingObject[]{p1,p2};
		FlyingObject obj = shootBy(b);
		System.out.println(p1);
		System.out.println(obj);
	}
	
}





