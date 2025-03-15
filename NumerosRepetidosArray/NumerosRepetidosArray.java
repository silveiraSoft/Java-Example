import java.util.*;
import java.util.stream.Collectors;
public class NumerosRepetidosArray {

    public static void main(String[] args) {
        

        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        //array to stream
        int count = (int) Arrays.stream(arr).distinct().count();
        System.out.println(count);

        //Arrays.stream(arr).collect(Collectors.toMap(null, null));
        Arrays.stream(arr).distinct().forEach(System.out::println);
        Arrays.stream(arr).distinct().collect(Collectors.toList()).forEach(System.out::println);
        Arrays.stream(arr).distinct().collect(Collectors.toSet()).forEach(System.out::println);
        Arrays.stream(arr).distinct().collect(Collectors.toMap(x -> x, x -> 1, Integer::sum)).forEach((k, v) -> System.out.println(k + " " + v));
        Arrays.stream(arr).collect(Collectors.toMap(x -> x, x -> 1, Integer::sum)).forEach((k, v) -> System.out.println(k + " " + v));
        Arrays.stream(arr).collect(Collectors.groupingBy(x -> x, Collectors.counting())).forEach((k, v) -> System.out.println(k + " " + v));

        Map<Integer, Integer> conteoIniciales = new HashMap<>();

        for (Integer integer : arr) {
            conteoIniciales.put(integer, conteoIniciales.getOrDefault(integer, 0) + 1);
        }
        conteoIniciales.forEach((k, v) -> System.out.println(k + " " + v));

        for(Map.Entry<Integer, Integer> entry : conteoIniciales.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");

        TreeMap<String, Integer> nameLengthMap = names.stream()
            .collect(Collectors.toMap(name -> name, String::length, (v1, v2) -> v1, TreeMap::new));

        System.out.println(nameLengthMap); // {Alice=5, Bob=3, Charlie=7}




    



        



        
        
        



        


    }
}