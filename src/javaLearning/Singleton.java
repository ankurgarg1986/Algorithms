package javaLearning;

import java.io.Serializable;

public class Singleton implements Cloneable,Serializable{
	
	private static volatile Singleton instance;

	private Singleton(){}
		
	public static Singleton getInstance() {
		
		if(instance == null){
			synchronized(Singleton.class){
			    if(instance==null){
				    instance = new Singleton();
			    }
			}
		}
		
		return instance;
	}

	
	
	

}
