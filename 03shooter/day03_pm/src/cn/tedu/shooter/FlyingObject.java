package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/** ����������� */
public abstract class FlyingObject {
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	protected int life = 1;
	/**
	 * ��ǰ�������ʾͼƬ�����������Ͷ��и��Ե�ͼƬ
	 */
	protected BufferedImage image;
	/**
	 * ����
	 */
	public void subtractLife(){
		life--;
	}
	/** destory������ */
	public void destory(){
		life=0;
	}
	/**
	 * ��鵱ǰ�������Ƿ��ǻ�� ��life>0��
	 * @return true ��ʾ������
	 */
	public boolean isActive(){
		return life>0;
	}
	
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
		double x1=this.x - other.width;
		double x2=this.x + this.width;
		double y1=this.y - other.height;
		double y2=this.y + this.height;
		//System.out.println(x1+","+x2);
		//System.out.println(y1+","+y2);
		//System.out.println(other.x+","+other.y);
		return x1<other.x && other.x<x2 &&
				y1<other.y && other.y<y2;
	}
	/**
	 * ���еķ����ﶼ�л��Ʒ������ô����еķ�����
	 * ���л��Ʒ������۷䣬�ɻ���
	 * ��յĻ��Ʋ�ͬ������д�� һ�¼���
	 */
	public void paint(Graphics g){
		g.drawImage(image, 
			(int)x, (int)y, null);
	}
	/** 
	 * FlyingObject �������ͨ�õĳ����鷽��
	 * ����true ��ʾ���磬 ����false��ʾû�г���
	 */
	public boolean outOfBounds(){
		return y >= Sky.HEIGHT;
//		if(y >= Sky.HEIGHT){
//			return true;
//		}else{
//			return false;
//		}
	}
}




