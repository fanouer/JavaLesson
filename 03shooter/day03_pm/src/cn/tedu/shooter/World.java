package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//����
import javax.swing.JPanel;//�װ�
//��ǩ

/**
 * ����
 * ��Ϸ������
 */
public class World extends JPanel{
	/** һƬ��� */
	private Sky sky;
	/** һ��Ӣ�� */
	private Hero hero;
	/** һȺ���� */
	private FlyingObject[] enemies;
	/** һ���ӵ��������е��ӵ� */
	private Bullet[] bullets;
	
	private int state;
	private static final int READY=0;
	private static final int RUNNING=1;
	private static final int PAUSE=2;
	private static final int GAME_OVER=3;
	
	
	/**
	 * ���þ�̬�����һ���ԵĶ�ȡ��̬��ͼƬ��Դ
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
		//���þ�̬������ȡͼƬ�ļ���ͼƬ����
		// background.png -> background
		try{//�������﷨�����ڴ����ȡͼƬʱ����������
			// ���� javax.imageio.ImageIO ��
			// ImageIO �� read ������һ��ͼƬ�ļ�
			// ��ȡ���ڴ���ΪBufferedImage���Ͷ���
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

			//����ͼƬ�Ƿ��ȡ�ɹ���
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
		//һƬ���
		//һ��Ӣ��
		//û���ӵ���û�е���
		sky = new Sky(background);
		hero = new Hero(heroImg);
		//һ���ӵ�����û�У������˳���Ϊ0������
		//�������ӵ�ʱ�����������������ӵ�
		bullets = new Bullet[0];
		enemies = new FlyingObject[0];
		
		state = READY;
	}
	
	/**
	 * ������д�޸� World�����JPanel��
	 * ��дpaint(Graphics g) ��������д�˷���
	 * ����ʵ���Զ�����ƣ�Ը�⻭ɶ�ͻ�ɶ�� 
	 * paint Ϳ��
	 * draw �滭
	 * Graphics ͼ������
	 */
	public void paint(Graphics g){
		//����ն������û���g���Լ���������
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
	 * ��World ������һ���������󶨶�ʱ������
	 * ������ʱ��������������ڲ��ࣩ���Թ���
	 * ��ǰ����������ˣ�
	 */
	private Timer timer;
	
	public void action(){
		//�����������ڲ��࣬���Թ��� �ⲿ�����
		//������
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
					//�ɻ���ʱ�볡
					planeEnter();
				}
				
				//���ɻ����ӵ��Ƿ�����ײ
				duangDuang();
				
				//���Ӣ���Ƿ���ĳ�ܷɻ�������ײ
				heroDuang();
				
				//����Ѿ�����ķɻ�
				checkOutOfBoundsPlane();
				//�������õķɻ�
				destroyPlanes();
				//�������Ķ���
				clearObjects();
				
				repaint();//����yλ�û���ͼƬ
			}

		}; 
		timer.schedule(task, 0, 1000/30); 
		
		//��action���������һ���������λ�õļ�����
		// ���λ����ӵ��ڲ��࣬���Է���Ĺ���
		// �ⲿ��World�Ķ������ݡ�
		//�������λ��
		MouseAdapter l =
				new MouseAdapter(){
			//�������������ƶ�ʱ���ִ���������
			//��д mouseMoved ����
			public void mouseMoved(
					MouseEvent e) {
				//System.out.println("Test");
				if(state==RUNNING){
					//��ȡ��굱ǰ��λ�ã���дhero��λ��
					int x = e.getX();
					int y = e.getY();
					hero.move(x, y); 
				}
			}
			/**
			 * ����뿪ʱ��ִ�еķ���
			 */
			public void mouseExited(
					MouseEvent e) {
				 if(state==RUNNING){
					 state = PAUSE;
				 }
			}
			/**
			 * ������ʱ��ִ��
			 */
			public void mouseEntered(
					MouseEvent e) {
				if(state==PAUSE){
					state = RUNNING;
				}
			}			
			/**
			 * ��굥��ʱ��ִ�еķ���
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
		//������¼���������l���󶨵���ǰ���
		//�ϣ�������ǰ��������˶������
		this.addMouseMotionListener(l); 
		//�����Ҫ������굥���¼����������¼�
		this.addMouseListener(l); 
	}
	
	/**
	 * ��World������ӷ��� 
	 */
	private void heroDuang() {
		FlyingObject obj = shootBy(hero);
		if(obj!=null){
			obj.destory();
			hero.subtractLife();
			if(! hero.isActive()){
				System.out.println("����");
				if(state == RUNNING){
					state=GAME_OVER;
				}
			}
		}
	}
	
	/**
	 * ��World���������ײ��鷽��
	 */
	private void duangDuang(){
		for(int i=0; i<bullets.length;i++){
			Bullet b = bullets[i];
			FlyingObject obj = shootBy(b);
			if(obj!=null){
				b.destory();
				//�ӵ�b������һ��������obj
				obj.subtractLife();
				if(! obj.isActive()){
					//getScore() getAward()
					if(obj instanceof Enemy){
						Enemy e = (Enemy)obj;
						int n = e.getScore();
						//System.out.println("�÷�:"+n);
						hero.add(n); 
					}
					if(obj instanceof Award){
						Award a = (Award)obj;
						int n = a.getAward();
						//System.out.println("��Ʒ:"+n); 
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
	 * ����ӵ�b���Ǽܷɻ����������null
	 * ��ʾû�д򵽷ɻ������ض��󣬱�ʾ��һ���ɻ� 
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
	 * �� World ������ӣ����ɻ�������㷨
	 * �ɻ�������������� life=0
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
	 * ����û�������ķɻ�
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
	 * ��World ������� �ɻ���ʱ�������㷨
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
			//��ε��ԣ�����ɻ������ݣ�
			enemies = Arrays.copyOf(
				enemies, enemies.length+1);
			enemies[enemies.length-1]=plane;
		}
	}
	 
	
	/**
	 * ��World ���� ���һ������������ķ���  
	 */
	private void clearObjects(){
		//�ҵ�ÿ���ӵ����󣬼���Ƿ������
		//�������ʹ�������ɾ����
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
	 * ��World�����������㷨��World ������
	 * ����Ӣ�۷ɻ���λ�ã� �����ӵ����顣
	 * ����Ӣ��λ�ã������ӵ���������ӵ����� 
	 */
	private int index=0;
	public void shoot(){
		index++;
		if(index%6 ==0){
			//���6��ִ��һ��
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
		
		JFrame frame = new JFrame();//�������ڶ���
		/** �����ڹرմ���ʱ���˳����� */
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE); 
		//JPanel panel = new JPanel();//����������
		//JLabel label = new JLabel("Hello");
		//panel.add(label);//�����ӱ�ǩ
		//frame.add(panel);//����������
		frame.add(world);
		frame.setSize(480, 600);//���ô�С
		frame.setVisible(true);//��ʾ���� 
		//Java frame ����ʾ��ʱ����Զ�
		// ����paint����
		// paint ������setVisible �ص�
		
		world.action();//�����˶�ʱ����
	}
	
	/**
	 * ��World ������Ӳ��Է���
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





