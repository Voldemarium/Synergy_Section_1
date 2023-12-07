package theme_6_data_structures.task_48;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer2.loyaltyPoints - customer1.loyaltyPoints;
    }
}
