package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/** ����������� */
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	/**
	 * ��ǰ�������ʾͼƬ�����������Ͷ��и��Ե�ͼƬ
	 */
	protected BufferedImage image;
	
	/*
	 * �ƶ�������
	 * �����˷��������ǿ����ƶ��ģ�
	 */
	public abstract void move();
	
	/*
	 * �����ײ��鷽���������Զ��̳��������
	 * ��鵱ǰ����������һ������������Ƿ���
	 * ��ײ��������Դ����ǰ����Ͳ���������һ������
	 */
	public boolean duang(
			FlyingObject other){
		int x1=this.x - other.width;
		int x2=this.x + this.width;
		int y1=this.y - other.height;
		int y2=this.y + this.height;
		return x1<other.x && other.x<x2 &&
				y1<other.y && other.y<y2;
	}
	/**
	 * ���еķ����ﶼ�л��Ʒ������ô����еķ�����
	 * ���л��Ʒ������۷䣬�ɻ���
	 * ��յĻ��Ʋ�ͬ������д�� һ�¼���
	 */
	public void paint(Graphics g){
		g.drawImage(image, x, y, null);
	}
}




