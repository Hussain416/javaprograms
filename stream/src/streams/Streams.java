package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	
	public static void main(String[] args) {
		
		// Example for filter in Streams
		// A filter is an operation in streams that takes a predicate(A boolean valued function) as input and returns a new stream containing only the elements that satisfy the predicate. In other words it removes the elements from the stream that do not meet the specified condition
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> evenNumbers = numbers.stream()
				.filter(n->n%2==1)
				.collect(Collectors.toList());
		
		System.out.println(evenNumbers);
		
		// Example for map in Streams
		// A map is an operation in streams that transforms each element in the stream into another element using the specified function. 
		List<String> names = Arrays.asList("Hussain","Sameer","Salman");
		List<String> uppercaseNames = names.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(uppercaseNames);
		
		
		//Example for reduce in Streams
		// A reduce is an operation in streams that combines all the elements in the streams into a single result. The reduce operation takes two parameters : an identity value(the starting value for the operation) and an accumulator function( a function that takes two elements and produces a new result). The accumulator function is applied repeatedly to all the elements in the stream, accumulating the results until a final value is produced. 
		List<Integer>numbers1 = Arrays.asList(1,2,3,4,5);
		int sum = numbers1.stream()
				.reduce(0, Integer::sum);
		System.out.println(sum);
		
	}

}
