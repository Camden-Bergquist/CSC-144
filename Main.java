/*
 * Camden Bergquist
 * CSC 144 - Object-Oriented Programming
 * 19 November 2021
 * The solution packet was heavily referenced for this submission
 */
package com.mycompany.csc144_week0_hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static List<Integer> makeList(int size, Random rng) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            list.add(n);
        }//for
        return list;
    }//makeList
    
    public static void printList(List<Integer> data) {
        for(int n : data) {
            System.out.println(n);
        }//for
    }//printList
    
    public static int minimumValue(List<Integer> data) {
        int bestGuessSoFar = data.get(0);
        
        for(int i = 1; i < data.size(); i++) {
            if(data.get(i) < bestGuessSoFar) {
                bestGuessSoFar = data.get(i);
            }//if
        }//for
        return bestGuessSoFar;
    }//minimumValue
    
    public static int positionOfMinimum(List<Integer> data) {
        int bestGuessSoFar = 0;
        
        for(int i = 1; i < data.size(); i++) {
            if(data.get(i) < data.get(bestGuessSoFar)) {
                bestGuessSoFar = i;
            }//if
        }//for
        return bestGuessSoFar;
    }//positionOfMinimum
    
    public static int positionOfMinimum(List<Integer> data, int start) {
        int bestGuessSoFar = start;
        
        for(int i = start + 1; i < data.size(); i++) {
            if(data.get(i) < data.get(bestGuessSoFar)) {
                bestGuessSoFar = i;
            }//if
        }//for
        return bestGuessSoFar;
    }//positionOfMinimum
    
    public static void exchange(List<Integer> data, int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }//exchange
    
    public static void selectionSort(List<Integer> data) {
        for(int i = 0; i < data.size(); i++) {
            int j = positionOfMinimum(data, i);
            exchange(data, i, j);
        }//for
    }//selectionSort
    
    public static void insert(List<Integer> data, int start) {
        int i = start;
        while(i > 0 && data.get(i) < data.get(i-1)) {
            exchange(data, i, i - 1);
        }//while
    }//insert
    
    public static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < a.size() && j < b.size()) {
            if(a.get(i) < b.get(j)) {
                c.add(a.get(i));
                i++;
            }//if
            else {
                c.add(b.get(j));
                j++;
            }//else
        }//while
        
        while(i < a.size()) {
            c.add(a.get(i));
            i++;
        }//while
        
        while(j < b.size()) {
            c.add(b.get(j));
            j++;
        }//while
        
        return c;
    }//merge
    
    public static void main(String[] args) {
        int numberOfSamples = 12;
        Random rng = new Random();
        List<Integer> samples = makeList(numberOfSamples, rng);
        
        System.out.println("List before sorting.");
        printList(samples);
        
        System.out.println();
        
        selectionSort(samples);
        System.out.println("List after sorting.");
        printList(samples);
        
        List<Integer> partlySorted = new ArrayList<>();
        partlySorted.add(2);
        partlySorted.add(5);
        partlySorted.add(9);
        partlySorted.add(14);
        partlySorted.add(16);
        partlySorted.add(10);
        partlySorted.add(3);
        partlySorted.add(7);
        
        System.out.println("\nFirst 5 elements in order.\n");
        printList(partlySorted);
        
        insert(partlySorted, 5);
        
        System.out.println("\nFirst 6 elements in order.\n");
        printList(partlySorted);
        
        List<Integer> a = makeList(6, rng);
        selectionSort(a);
        
        List<Integer> b = makeList(6, rng);
        selectionSort(b);
        
        List<Integer> c = merge(a, b);
        
        System.out.println("\nA short sorted list.\n");
        printList(a);
        System.out.println("\nAnother short sorted list.\n");
        printList(b);
        System.out.println("\n A merger of the two short sorted lists.\n");
        printList(c);
    }//main
    
}//Main
