package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMV", 1234);
      Car car2 = new Car("Camry", 5678);
      Car car3 = new Car("Нива", 9101);
      Car car4 = new Car("RAV4", 1121);

      userService.add(new User("Ivan", "Petrov", "user1@mail.ru","24",car1));
      userService.add(new User("Adam", "Imanaliev", "user2@mail.ru","23",car2));
      userService.add(new User("Maria", "Ivanova", "user3@mail.ru","22",car3));
      userService.add(new User("Smit", "Jon", "user4@mail.ru","26",car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("Name = "+user.getName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("__________________________________");
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
