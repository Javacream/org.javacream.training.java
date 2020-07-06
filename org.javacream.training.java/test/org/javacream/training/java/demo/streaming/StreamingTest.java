package org.javacream.training.java.demo.streaming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StreamingTest {

	private List<String> names;
	@Before public void before() {
		names = new ArrayList<String>();
		names.add("Hugo");
		names.add("Fridolin");
		names.add("Emil");
		names.add("Fritz");
		names.add("Franz");

		
	}
	
	@After public void finishTest() {
		System.out.println("__________________________");
	}
	//@Test 
	
	public void classicForEach() {
		for (String name: names) {
			System.out.println(name);
		}
	}
	//@Test 
	public void oopForEach() {
		names.forEach(s -> System.out.println(s));
		
	}

	@Test public void dataWithStreaming() {
		Stream<String> stringStream = names.stream();
		data(stringStream);
		
	}
	
	private void data(Stream<String> stringStream) {
		Consumer <Integer> printOut = s -> System.out.println(s);
		Predicate<String> filter = s -> s.startsWith("F");
		Function<String, Integer> transformer = s -> s.length();
		Comparator<String> sorter = (s1, s2) -> s1.compareTo(s2);

		Stream<String> filtered = stringStream.filter(filter);
		Stream<String> sorted = filtered.sorted(sorter);
		Stream<Integer> transformed = sorted.map(transformer);
		transformed.forEach(printOut);
		
	}

	
	private void dataCompacted(Stream<String> stringStream) {
		Consumer <Integer> printOut = s -> System.out.println(s);
		Predicate<String> filter = s -> s.startsWith("F");
		Function<String, Integer> transformer = s -> s.length();
		Comparator<String> sorter = (s1, s2) -> s1.compareTo(s2);

		stringStream.filter(filter).sorted(sorter).map(transformer).forEach(printOut);
		
	}
	private void dataVeryCompacted(Stream<String> stringStream) {
		stringStream.filter(s -> s.startsWith("F")).sorted((s1, s2) -> s1.compareTo(s2)).map(s -> s.length()).forEach(s -> System.out.println(s));
		
	}

	private void collectData(Stream<String> stringStream) {
		List<Integer> result = stringStream.filter(s -> s.startsWith("F")).sorted((s1, s2) -> s1.compareTo(s2)).map(s -> s.length()).collect(Collectors.toList());
		System.out.println(result);
	}


}
