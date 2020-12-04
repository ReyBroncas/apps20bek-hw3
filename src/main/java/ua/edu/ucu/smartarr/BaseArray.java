package ua.edu.ucu.smartarr;

public class BaseArray implements SmartArray {
    private Object[] arr;
    private int size;

    public BaseArray(Object[] arr) {
        this.arr = new Object[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        this.size = arr.length;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; ++i) {

            output.append((String) arr[i]);
        }
        return output.toString();
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return size;
    }
}
