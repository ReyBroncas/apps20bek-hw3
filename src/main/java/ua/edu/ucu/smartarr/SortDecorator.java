package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.setSmartArray(new BaseArray(manipulate(cmp)));
    }

    private Object[] manipulate(MyComparator cmp) {
        Object[] currArray = smartArray.toArray();
        Arrays.sort(currArray, cmp);
        return currArray;
    }

    public String toString() {
        return smartArray.toString();
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
