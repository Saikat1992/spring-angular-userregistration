package com.javatechie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperation {
	public static void main(String[] args) {
		String str="iampapaisarangi";
		
		Map<String, Long> uniqueChar= Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		List<String> uniqueEl= Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(x->x.getValue()>1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
		
		List<String> duplicateElements= Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(x->x.getValue()>1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(duplicateElements);
		
		System.out.println(uniqueChar);
	}

}
