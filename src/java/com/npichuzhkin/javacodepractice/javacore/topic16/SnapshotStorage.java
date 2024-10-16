package com.npichuzhkin.javacodepractice.javacore.topic16;

import java.util.Stack;

public class SnapshotStorage {
    private Stack<Snapshot> snapshots = new Stack<>();

    public void addSnapshot(Snapshot s){
        snapshots.push(s);
    }

    public Snapshot undo(){
        if (!snapshots.empty()) return snapshots.pop();
        throw new NullPointerException();
    }
}
