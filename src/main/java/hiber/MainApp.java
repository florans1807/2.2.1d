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
/*

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car(1, "x5", new User("User11", "Lastname11", "user11@mail.ru"));
      Car car2 = new Car(2, "x6", new User("User12", "Lastname12", "user12@mail.ru"));
      Car car3 = new Car(3, "x7", new User("User13", "Lastname13", "user13@mail.ru"));

      userService.add(new User("User7", "Lastname7", "user7@mail.ru", car1));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", car2));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", car3));
*/

      Car car1 = new Car(1, "a");
      User user1 = new User();
      user1.setFirstName("evgeny");
      user1.setLastName("yakovlev");
      user1.setEmail("iakovlevjenya21@mail.ru");
      car1.setOwner(user1);
      user1.setCar(car1);

      userService.add(user1);




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
