package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

public class FilterDecorator extends SmartArrayDecorator {
    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.setSmartArray(new BaseArray(manipulate(pr)));
    }

    private Object[] manipulate(MyPredicate pr) {
        Object[] currArray = smartArray.toArray();
        int size = smartArray.size();
        int numOfValuesToRemove = 0;

        for (int i = 0; i < size; ++i) {
            if (!pr.test(currArray[i])) {
                ++numOfValuesToRemove;
            }
        }

        int newSize = size - numOfValuesToRemove;
        Object[] newArray = new Object[newSize];
        int j = 0;


        for (int i = 0; i < size; ++i) {
            if (pr.test(currArray[i])) {
                newArray[j] = currArray[i];
                ++j;
            }
        }

        return newArray;
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
        return "Deletes values that are not 'approved' by given MyPredicate.";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
