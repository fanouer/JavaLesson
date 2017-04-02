package cn.tedu.shooter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//����
import javax.swing.JPanel;//�װ�
import javax.swing.JLabel;//��ǩ

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
			//����ͼƬ�Ƿ��ȡ�ɹ���
			System.out.println(background);	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public World() {
		//һƬ���
		//һ��Ӣ��
		//û���ӵ���û�е���
		sky = new Sky(background);
		hero = new Hero();
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
		g.setColor(Color.BLUE); 
		g.drawLine(0, 0, 10, 10);
		//�� 0,0 λ������sky��ͼƬ
		g.drawImage(sky.image, 0, 0, null);
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
		
	}
}





