package W11.Z02;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{2,1,3,5}));
    }
    public List<String> fizzBuzz(int n) {
        StringBuilder builder = new StringBuilder();
        return IntStream.range(1, n+1)
                .mapToObj(i->{
                    if (i%3==0)
                        builder.append("Fizz");
                    if (i%5==0)
                        builder.append("Buzz");
                    if (builder.isEmpty())
                        builder.append(i);
                    return builder.toString();
                })
                .peek(i->builder.setLength(0))
                .toList();
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        SortedSet<Integer> integers = new TreeSet<>();
        Arrays.stream(nums1).forEach(integers::add);
        Arrays.stream(nums2).forEach(integers::add);
        List<Integer> integers1 = integers.stream().toList();
        if (integers1.size()%2!=0)
            return integers1.get(integers1.size()/2);
        integers1.forEach(i-> System.out.println("Lista : " + i));
        double a = integers1.get((integers1.size()-1)/2);
        double b = integers1.get((integers1.size())/2);
        return (a+b)/2;
    }
    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        Arrays.stream(nums)
                .forEach(i -> {
                    if (i>=1)
                        integers.add(i);
                });
        int last = 0;
        Iterator<Integer> iterator = integers.iterator();
        do{
            last++;
        }while (iterator.hasNext() && iterator.next().equals(last));
        return last;
    }
}