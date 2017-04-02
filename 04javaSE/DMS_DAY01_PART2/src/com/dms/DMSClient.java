package com.dms;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dms.bo.LogData;


/**
 * 该客户端运行在给用户提供unix服务的服务器上。
 * 用来读取并收集该服务器上用户的上下线信息，并
 * 进行配对整理后发送给服务端汇总。
 * @author Administrator
 *
 */
public class DMSClient {
	//属性定义
	
	//第一步:解析日志所需属性
	//unix系统日志文件
	private File logFile;
	//保存解析后日志的文件
	private File textLogFile;
	//书签文件
	private File lastPositionFile;
	//每次解析日志的条目数
	private int batch;
	
	//第二步:配对日志所需要属性
	//保存配对日志的文件
	private File logRecFile;
	//保存未配对日志的文件
	private File loginLogFile;
	
	//第三步:发送日志所需要属性
	//服务端地址
	private String serverHost;
	//服务端端口
	private int serverPort;
	/**
	 * 构造方法，用来初始化客户端
	 * @throws Exception 
	 */
	public DMSClient() throws Exception{
		try {
			//1 解析配置文件config.xml
			Map<String,String> config = loadConfig();
			//打桩
			System.out.println(config);
			
			//2 根据配置文件内容初始化属性
			init(config);
			
		} catch (Exception e) {
			System.out.println("初始化失败!");
			throw e;
		}
	}
	/**
	 * 构造方法初始化第二步,根据配置项初始化属性
	 * @param config
	 * @throws Exception 
	 */
	private void init(Map<String,String> config) throws Exception{
		try {
			logFile = new File(
				config.get("logfile")
			);
			textLogFile = new File(
				config.get("textlogfile")	
			);
			lastPositionFile = new File(
				config.get("lastpositionfile")	
			);
			batch = Integer.parseInt(
				config.get("batch")
			);
			logRecFile = new File(
				config.get("logrecfile")	
			);
			loginLogFile = new File(
				config.get("loginlogfile")	
			);
			serverHost = config.get("serverhost");
			serverPort = Integer.parseInt(
				config.get("serverport")	
			);			
			
		} catch (Exception e) {
			System.out.println("初始化属性失败!");
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * 构造方法初始化第一步，解析配置文件
	 * @return 返回的Map中保存的是配置文件中的
	 *         每一条内容，其中key:标签的名字，
	 *         value为标签中间的文本
	 * @throws Exception 
	 */
	private Map<String,String> loadConfig() throws Exception{
		try {
			SAXReader reader = new SAXReader();
			Document doc
				= reader.read(new File("config.xml"));
			Element root = doc.getRootElement();
			
			Map<String,String> config
				= new HashMap<String,String>();
			/*
			 * 获取<config>标签中的所有子标签
			 * 并将每一个子标签的名字作为key,中间的
			 * 文本作为value存入Map集合
			 */
			List<Element> list = root.elements();
			for(Element e : list){
				String key = e.getName();
				String value = e.getTextTrim();
				config.put(key, value);
			}
			return config;
		} catch (Exception e) {
			System.out.println("解析配置文件异常!");
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 客户端开始工作的方法
	 * 循环执行三步:
	 * 1:解析日志
	 */
	public void start(){
		parseLogs();		
	}
	/**
	 * 第一步:解析日志
	 * @return true:解析成功
	 *         false:解析失败
	 */
	private boolean parseLogs(){
		/*
		 * 实现思路:
		 * 循环读取batch条日志，然后将每条日志中的
		 * 5个信息解析出来，最终组成一个字符串，以
		 * 行为单位，写入到textLogFile文件中
		 * 
		 * 实现步骤：
		 * 1:必要的判断工作
		 *   1.1:为了避免解析的日志还没有被使用，而
		 *       第一步又重复执行导致之前日志被覆盖
		 *       的问题，这里需要判断，若保存解析后
		 *       的日志文件存在，则第一步不再执行。
		 *       该日志文件会在第二步配对完毕后删除。
		 *   1.2:logFile文件必须存在(wtmpx文件)
		 *   1.3:是否还有日志可以解析
		 * 2:创建RandomAccessFile来读取logFile
		 * 3:将指针移动到上次最后读取的位置，准备
		 *   开始新的解析工作
		 * 4:解析工作
		 *   4.1:创建一个List集合，用于保存解析后
		 *       的每一条日志(LogData实例)
		 *   4.2:循环batch次，解析每条日志中的
		 *       5项内容(user,pid,type,time,host)
		 *       并用一个LogData实例保存，然后将
		 *       该LogData实例存入集合
		 * 5:将集合中的所有的日志以行为单位保存到
		 *   textLogFile中 
		 * 6:保存书签信息         
		 * 7:返回true,表示工作完毕
		 * 
		 */
		RandomAccessFile raf = null;
		try {
			//1
			//1.1
			if(textLogFile.exists()){
				return true;
			}
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"不存在!");
				return false;
			}
			//1.3
			long lastPosition = hasLogs();
			//打桩
//			System.out.println(
//					"lastPosition:"+lastPosition
//			);
			
			if(lastPosition<0){
				System.out.println("没有日志可以解析了!");
				return false;
			}
			
			//2
			raf = new RandomAccessFile(logFile,"r");
			
			//3
			raf.seek(lastPosition);
			
			//4
			List<LogData> list
				= new ArrayList<LogData>();
			for(int i=0;i<batch;i++){
				//每次解析前都判断是否还有日志可以解析
				if(logFile.length()-lastPosition
						<LogData.LOG_LENGTH
				){
					break;
				}
				//解析user
				raf.seek(lastPosition+LogData.USER_OFFSET);
				String user 
					= IOUtil.readString(
							raf, LogData.USER_LENGTH
						).trim();
				
				//解析PID
				raf.seek(lastPosition+LogData.PID_OFFSET);
				int pid = raf.readInt();
				
				//解析TYPE
				raf.seek(lastPosition+LogData.TYPE_OFFSET);
				short type = raf.readShort();
				
				//解析TIME
				raf.seek(lastPosition+LogData.TIME_OFFSET);
				int time = raf.readInt();
				
				//解析HOST
				raf.seek(lastPosition+LogData.HOST_OFFSET);
				String host 
					= IOUtil.readString(
							raf, LogData.HOST_LENGTH
						).trim();
				
				LogData log = new LogData(user, pid, type, time, host);
				
				list.add(log);
				//打桩
//				System.out.println(log);
				
				//当解析完一条日志后，更新lastPosition
				lastPosition = raf.getFilePointer();
			}
			
			//5
			IOUtil.saveCollection(list, textLogFile);
			
			//6 保存书签文件
			IOUtil.saveLong(
					lastPosition, lastPositionFile);
			
			//7
			return true;
			
			
		} catch (Exception e) {
			System.out.println("解析日志失败!");
			e.printStackTrace();
		} finally{
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	/**
	 * 第一步解析日志中的一个环节，
	 * 根据书签文件记录的位置判断是否还有
	 * 日志可以解析，若有，则将上次最后的位置
	 * 返回，若没有则返回-1。
	 * @return
	 */
	private long hasLogs(){
		try {
			/*
			 * 实现步骤:
			 * 1:若lastPositionFile不存在，则说明
			 *   从来没有解析过，那么从头开始解析即可，返回0
			 *   若存在，则读取里面记录的数字，该数字在文件中
			 *   的第一行，是一个字符串，读取出来需要转换为long
			 *   值。
			 * 2:判断上次读取的位置与文件的长度，若文件的长度
			 *   减去上次读取的位置大于等于一条日志的长度，则
			 *   说明还有日志可以读取，那么直接将上次的位置返回，
			 *   从这里读取即可，若不足则返回-1.  
			 */
			if(!lastPositionFile.exists()){
				return 0;
			}
			
			long lastPosition 
				= IOUtil.readLong(lastPositionFile);
			
			if(logFile.length()-lastPosition
					>=LogData.LOG_LENGTH){
				return lastPosition;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		try {
			DMSClient client = new DMSClient();
			client.start();
		} catch (Exception e) {
			System.out.println("客户端运行失败!");
		}
	}
}








