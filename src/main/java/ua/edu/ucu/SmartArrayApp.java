package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate studentsSelect = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= 4 && ((Student) t).getYear() == 2;
            }
        };
        MyComparator sortBySurname = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student)
                        o2).getSurname());
            }
        };
        MyFunction getSurname = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " " + ((Student) t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);
        sa = new SortDecorator(sa, sortBySurname);
        sa = new FilterDecorator(sa, studentsSelect);
        sa = new DistinctDecorator(sa);
        sa = new MapDecorator(sa, getSurname);


        Object[] output = sa.toArray();
        return Arrays.copyOf(output, output.length, String[].class);
    }
}
