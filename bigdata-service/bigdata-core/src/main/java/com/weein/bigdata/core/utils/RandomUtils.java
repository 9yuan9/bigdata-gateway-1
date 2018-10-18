package com.weein.bigdata.core.utils;

import java.util.Random;

public class RandomUtils {
	private static final Random random = new Random();
	
	public static Integer getRandomInt(Integer max){
		return random.nextInt(max);
	}
}
