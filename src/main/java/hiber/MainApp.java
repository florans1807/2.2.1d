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

      Car car1 = new Car(1, "a");
      User user1 = new User("evgeny", "yakovlev", "iakovlevjenya21@mail.ru");
      car1.setOwner(user1);
      user1.setCar(car1);

      Car car2 = new Car(2, "b");
      User user2 = new User("ivan", "ivanov", "jenya21@mail.ru");
      car2.setOwner(user2);
      user2.setCar(car2);

      Car car3 = new Car(3, "c");
      User user3 = new User("dsdsx", "saxasqsd", "iakovlev21@mail.ru");
      car3.setOwner(user3);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByModelAndSeries(car3).getId());

      context.close();
   }
}
