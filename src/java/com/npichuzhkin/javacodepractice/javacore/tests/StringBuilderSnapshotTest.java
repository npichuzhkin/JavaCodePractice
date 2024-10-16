package com.npichuzhkin.javacodepractice.javacore.tests;

import com.npichuzhkin.javacodepractice.javacore.topic16.StringBuilderSnapshot;

public class StringBuilderSnapshotTest {
    public static void main(String[] args) {
        StringBuilderSnapshot sbs = new StringBuilderSnapshot("sbs");
        System.out.println("Создан новый объект: " + sbs);

        for (int i = 0; i < 5; i++) {
            System.out.println("Объект изменён: " + sbs.append(i+""));
        }


        for (int i = 0; i < 5; i++) {
            sbs.undo();
            System.out.println("Объект откатился: " + sbs);
        }
    }
}
