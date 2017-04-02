package day09;

public class Test {
	public boolean getMoney(int money){
		//获取该用户余额
		int count = getCount();		
		if(count>=money){
			count = count - money;
			saveCount(count);
			return true;
		}
		return false;
	}
	public void saveCount(int count){
		
	}
	public int getCount(){
		return 0;
	}
}
