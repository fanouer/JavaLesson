package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Sky 
	extends FlyingObject{
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 852;
	
	public Sky(BufferedImage image) {
		//��ʼ�� ��յı���ͼƬ
		//World �ྲ̬��ȡͼƬ�ļ�.png��ͼƬ����
		//���ù������������ݵ�ǰ������
		this.image = image;
	}
	
	public void move() {
		
	}
	
}
