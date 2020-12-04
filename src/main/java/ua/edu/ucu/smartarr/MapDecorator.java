package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;


public class MapDecorator extends SmartArrayDecorator {
    public MapDecorator(SmartArray smartArray, MyFunction mf) {

        super(smartArray);
        this.smartArray = new BaseArray(manipulate(mf));
//        this.setSmartArray(new BaseArray(manipulate(mf)));
//        Object[] test = manipulate(mf);

    }

    private Object[] manipulate(MyFunction mf) {
        int size = this.smartArray.size();
        Object[] newArray = smartArray.toArray();

        for (int i = 0; i < size; ++i) {
            newArray[i] = mf.apply(newArray[i]);
        }
        return newArray;
    }

    public String toString() {
        return smartArray.toString();
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applies functions to values.";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
