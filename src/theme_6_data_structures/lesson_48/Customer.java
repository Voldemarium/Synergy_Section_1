package theme_6_data_structures.lesson_48;

public class Customer implements Comparable<Customer>{
    String fullName;
    int loyaltyPoints;

    public Customer(String fullName, int loyaltyPoints) {
        this.fullName = fullName;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public int compareTo(Customer o) {
        return o.loyaltyPoints - this.loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
