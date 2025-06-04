import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
    public int solve(int[] pElements) {
        int n = pElements.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(pElements[i])){
                map.put(pElements[i], map.get(pElements[i]) + 1);
            }else{
                map.put(pElements[i], 1);
            }
        }
        int max = 0;
        int secondMax = 0;
        int maxElement = 0;
        int secondMaxElement = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                secondMax = max;
                secondMaxElement = maxElement;
                max = entry.getValue();
                maxElement = entry.getKey();
            }else if(entry.getValue() > secondMax && entry.getValue() != max){
                secondMax = entry.getValue();
                secondMaxElement = entry.getKey();
            }
        }
        return secondMaxElement;
    }
}

class Solution2 {
    public int solve(int[] pElements) {
        if (pElements == null || pElements.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(pElements).forEach(e -> map.put(e, map.getOrDefault(e, 0) + 1));
        
        return map.entrySet().stream()
                .filter(entry -> !Objects.equals(entry.getValue(), Collections.max(map.values())))
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No second frequent element found"));
    }
}

class Solution3 {
    public int solve(int[] pElements) {
        if (pElements == null || pElements.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        return Arrays.stream(pElements)
                .boxed()
                .collect(Collectors.toMap(e -> e, e -> (int) Arrays.stream(pElements).filter(x -> x == e).count(),
                        (key, value) -> key))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
                .limit(2)
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("No second frequent element found"));

    }
}

class Solution4 {
    public int solve(int[] pElements) {
        if (pElements == null || pElements.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        return Arrays.stream(pElements)
                .boxed()
                //.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                //.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                //.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //.sorted((e, f) -> Long.compare(f.getValue(), e.getValue()))
                //.sorted((e, f) -> f.getValue().compareTo(e.getValue()))
                /*
                .sorted((e, f) -> {
                    int result = f.getValue().compareTo(e.getValue());
                    if (result == 0) {
                        return Integer.compare(e.getKey(), f.getKey());
                    }
                    return result;
                })
                /* 
                .sorted((e, f) -> {
                    return f.getValue() > e.getValue()? 1: -1;
                })*/
                .limit(2)
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("No second frequent element found"));

    }
}

public class SecondMoreFrequentElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] elements = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(solution.solve(elements)); // Output: 2
        System.out.println(solution2.solve(elements)); // Output: 2
        System.out.println(new Solution3().solve(elements)); // Output: 2
        System.out.println(new Solution4().solve(elements));

    }
}
