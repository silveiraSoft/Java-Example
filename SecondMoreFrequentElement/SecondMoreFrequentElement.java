import java.util.Map;
import java.util.HashMap;

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

public class SecondMoreFrequentElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(solution.solve(elements)); // Output: 2
    }
}
