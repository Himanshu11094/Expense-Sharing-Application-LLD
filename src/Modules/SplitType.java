package Modules;

import java.util.HashMap;

public enum SplitType {

	EXPENSE ("EXPENSE"), 
	SHOW ("SHOW"), 
	QUIT ("QUIT");
	
	private final String name;
	
	SplitType(String str)
	{
		name = str;
	}
	
	public String toString()
	{
		return this.name;
	}
	
	private static final HashMap<String, SplitType> map = new HashMap<>(values().length, 1);
	
	static
	{
		for(SplitType c: values()) map.put(c.name, c);
	}
	
	public static SplitType of(String name)
	{
		return map.get(name);
	}
	
}
