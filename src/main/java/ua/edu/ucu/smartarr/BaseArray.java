package ua.edu.ucu.smartarr;

import java.util.Arrays;

public class BaseArray implements SmartArray {
    private Object[] arr;
    private int size;

    public BaseArray(Object[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
