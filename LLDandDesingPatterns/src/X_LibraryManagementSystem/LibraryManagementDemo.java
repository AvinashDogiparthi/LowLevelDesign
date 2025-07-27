package X_LibraryManagementSystem;

import X_LibraryManagementSystem.Order.Order;
import X_LibraryManagementSystem.User.User;
import X_LibraryManagementSystem.User.UserTypeEnum;

public class LibraryManagementDemo {

    public static void main(String[] args) {

        Library library = Library.getInstance();

        library.registerUser("U001", "Avinash", 1234567890L, UserTypeEnum.ADMIN);
        library.registerUser("U002", "John", 9876543210L, UserTypeEnum.CUSTOMER);
        library.registerUser("U003", "Alice", 1122334455L, UserTypeEnum.CUSTOMER);
        library.registerUser("U004", "Bob", 5566778899L, UserTypeEnum.CUSTOMER);
        library.registerUser("U005", "Charlie", 9988776655L, UserTypeEnum.CUSTOMER);
        library.registerUser("U006", "Diana", 1231231234L, UserTypeEnum.CUSTOMER);
        library.registerUser("U007", "Ethan", 4564564567L, UserTypeEnum.CUSTOMER);
        library.registerUser("U008", "Fiona", 7897897890L, UserTypeEnum.CUSTOMER);

        library.addBook("U001", "B001", "Effective Java", "Joshua Bloch", 50);
        library.addBook("U001", "B002", "Clean Code", "Robert C. Martin", 40);
        library.addBook("U001", "B003", "Design Patterns", "Erich Gamma", 60);


        Order order1 = library.borrowBook("U002", "B001");
        Order order2 = library.borrowBook("U003", "B001");
        Order order3 = library.borrowBook("U004", "B001");
        Order order4 = library.borrowBook("U005", "B001");
        Order order5 = library.borrowBook("U006", "B001");
        Order order6 = library.borrowBook("U007", "B001");

        library.handOverBook("U001", "B001",String.valueOf(order1.getOrderID()));
    }
}
