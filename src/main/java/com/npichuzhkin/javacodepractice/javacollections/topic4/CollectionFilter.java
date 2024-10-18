package com.npichuzhkin.javacodepractice.javacollections.topic4;

public class CollectionFilter {
    public static <T> T[] filter(T[] someTypeArray, Filter f){
        T[] newArray = (T[]) new Object[someTypeArray.length];
        for (int i = 0; i < someTypeArray.length; i++) {
            newArray[i] = (T) f.apply(someTypeArray[i]);
        }
        return newArray;
    }
}
