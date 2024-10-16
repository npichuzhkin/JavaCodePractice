package com.npichuzhkin.javacodepractice.javacore.topic16;

public class StringBuilderSnapshot {
    private char[] value;
    private int count;
    private SnapshotStorage snapshotStorage;

    public StringBuilderSnapshot() {
        this.value = new char[16];
        this.count = 0;
        this.snapshotStorage = new SnapshotStorage();
    }

    public StringBuilderSnapshot(String str) {
        this.value = new char[str.length() + 16];
        this.snapshotStorage = new SnapshotStorage();
        append(str);
        snapshotStorage.addSnapshot(new Snapshot(this.toString()));
    }

    public StringBuilderSnapshot append(String str) {
        if (str == null) {
            str = "null";
        }
        int len = str.length();
        ensureCapacity(count + len);
        str.getChars(0, len, value, count);
        count += len;
        snapshotStorage.addSnapshot(new Snapshot(this.toString()));
        return this;
    }

    public StringBuilderSnapshot delete(int start, int end) {
        if (start < 0 || start > count || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        int len = end - start;
        if (len > 0) {
            System.arraycopy(value, start + len, value, start, count - end);
            count -= len;
        }
        snapshotStorage.addSnapshot(new Snapshot(this.toString()));
        return this;
    }

    public String toString() {
        return new String(value, 0, count);
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > value.length) {
            int newCapacity = Math.max(value.length * 2, minimumCapacity);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    public int length() {
        return count;
    }

    public char charAt(int index) {
        if (index < 0 || index >= count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    public void undo(){
        StringBuilderSnapshot sbs = new StringBuilderSnapshot("" + snapshotStorage.undo().getSnapshot());
        value = sbs.value;
        count = sbs.count;
    }

}
