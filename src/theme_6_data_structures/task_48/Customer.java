package theme_6_data_structures.task_48;

public class Customer{
    String fullName;
    int loyaltyPoints;

    public Customer(String fullName, int loyaltyPoints) {
        this.fullName = fullName;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
