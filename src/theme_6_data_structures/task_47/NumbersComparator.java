package theme_6_data_structures.task_47;

import java.util.Comparator;

public class NumbersComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        boolean isEvenI1 = i1 % 2 == 0;
        boolean isEvenI2 = i2 % 2 == 0;
        if (isEvenI1 && !isEvenI2) {
            return -1;
        } else if (!isEvenI1 && isEvenI2)  {
            return 1;
        }else if (isEvenI1) {
            return i1 - i2;
        } else {
            return i2 - i1;
        }
    }
}
