package stream;

import java.util.stream.Stream;

public class ReadOnce {
    public static void main(String[] args) {
        // Exception in thread "main" java8inactionjava.lang.IllegalStateException: stream has already been operated upon or closed
        Stream<String> stream = Stream.of("java8", "in", "action");
        stream.forEach(System.out::print);
        stream.forEach(System.out::print);
    }
}
