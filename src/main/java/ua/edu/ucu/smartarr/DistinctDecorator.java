package ua.edu.ucu.smartarr;


public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.setSmartArray(new BaseArray(manipulate()));
    }

    private Object[] manipulate() {
        int size = smartArray.size();
        int k = 0;
        Object[] currArray = smartArray.toArray();
        Integer[] itemsToRemove = new Integer[size];

        for (int i = size - 1; i >= 0; --i) {
            for (int j = i - 1; j >= 0; --j) {
                if (currArray[i].toString().equals(currArray[j].toString())) {
                    itemsToRemove[k] = i;
                    ++k;
                    break;
                } else {
                }
            }
        }

        int newSize = size - k;
        int j = newSize - 1;
        k = 0;
        Object[] newArray = new Object[newSize];

        for (int i = size - 1; i >= 0; --i) {
            if (itemsToRemove[k] != null && i == itemsToRemove[k]) {
                ++k;
            } else {
                newArray[j] = currArray[i];
                --j;
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
        return "Deletes duplicated objects";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
