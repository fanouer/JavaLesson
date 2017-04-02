package cn.tedu.shooter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//����
import javax.swing.JPanel;//�װ�
import javax.swing.JLabel;//��ǩ

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

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
	
	/**
	 * ���þ�̬�����һ���ԵĶ�ȡ��̬��ͼƬ��Դ
	 */
	private static BufferedImage background;
	private static BufferedImage airplane;
	private static BufferedImage bigPlane;
	private static BufferedImage bee;
	private static BufferedImage heroImg;
	private static BufferedImage bullet;
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
		//g.setColor(Color.BLUE); 
		//g.drawLine(0, 0, 10, 10);
		//�� 0,0 λ������sky��ͼƬ
		//g.drawImage(sky.image, 
		//		sky.x, sky.y1, null);
		//g.drawImage(sky.image, 
		//		sky.x, sky.y2, null);
		
		//����ն������û���g���Լ���������
		sky.paint(g);
		hero.paint(g);
		//g.drawImage(hero.image, 20, 100, null);
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
				sky.move();//�޸�y
				//repaint�����»��ƣ��ػ�,repaint���Ը���
				// JPanel �ķ�������������ᾡ���ִ��paint
				// ���� paint ��������ͼƬ����������»��ơ�
				repaint();//����yλ�û���ͼƬ
			}
		}; 
		timer.schedule(task, 0, 1000/30); 
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
}





