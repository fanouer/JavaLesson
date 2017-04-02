package controller;
/**
 * 使用自动机制封装成一个bean，
 * 要注意，类型转换有可能会出错。
 *
 */
public class BmiParam {
	private double height;
	private double weight;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
