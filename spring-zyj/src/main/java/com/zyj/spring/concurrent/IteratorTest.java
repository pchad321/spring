package com.zyj.spring.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.put(i + "", i + "");
		}

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry item = (Map.Entry) it.next();
			map.remove(item.getKey());
		}
	}
}
