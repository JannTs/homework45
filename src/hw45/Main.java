package hw45;

/**
 * Написать метод, принимающий не пустой лист целых чисел ,
 * в котором все числа кроме одного имеют пару и возвращающий это не парное число.
 * При решении использовать мапу
 *
 * Примеры:
 * 1,3,1 -> 3
 * 3,3,3 -> 3
 * 1,1,15,1,1 -> 15
 * 1,8,8,8,8,8,1,2,2 -> 8
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int findOddOccurrence(List<Integer> numbers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        //correctly increase the value by 1 when merging keys
        //numbers.forEach(num -> countMap.put(num, countMap.getOrDefault(num, 0) + 1));
        //or
        numbers.forEach(num -> countMap.merge(num, 1, (oldValue,newValue)->oldValue + 1));

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        // if not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(1, 3, 1);
        int result1 = findOddOccurrence(numbers1);
        System.out.println("Result 1: " + result1);
        List<Integer> numbers2 = List.of(3, 3, 3);
        int result2 = findOddOccurrence(numbers2);
        System.out.println("Result 2: " + result2);
        List<Integer> numbers3 = List.of(1, 1, 15, 1, 1);
        int result3 = findOddOccurrence(numbers3);
        System.out.println("Result 3: " + result3);
        List<Integer> numbers4 = List.of(1, 8, 8, 8, 8, 8, 1, 2, 2);
        int result4 = findOddOccurrence(numbers4);
        System.out.println("Result 4: " + result4);
        List<Integer> numbers5 = List.of(1, 7, 7, 7, 7, 1, 2, 2);
        int result5 = findOddOccurrence(numbers5);
        System.out.println("Result 5 " + result5);
        List<Integer> numbers6 = List.of(1, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 1, 2, 2);
        int result6 = findOddOccurrence(numbers6);
        System.out.println("Result 6 " + result6);
    }
}
