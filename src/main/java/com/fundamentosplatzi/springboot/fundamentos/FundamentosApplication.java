package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimientoWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyMovimientoWithDependency myMovimientoWithDependency;

    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    private UserRepository userRepository;

    private UserService userService;


    //El autowired ya no es obligatorio
    @Autowired
    public FundamentosApplication(
            @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependency myBeanWithDependency,
            MyMovimientoWithDependency myMovimientoWithDependency,
            MyBeanWithProperties myBeanWithProperties,
            UserPojo userPojo,
            UserRepository userRepository,
            UserService userService
    ){
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myMovimientoWithDependency = myMovimientoWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

    @Override
    public void run(String... args) {
        //ejemplosAnteriores();

        saveUserInDataBase();
        getInformationJpqlFromUser();
        saveWithErrorTransaction();

    }

    private void saveWithErrorTransaction(){
        User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test2 = new User("Test2Transactional1", "Test2Transactional1@domain.com", LocalDate.now());
        User test3 = new User("Test3Transactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test4 = new User("Test4Transactional1", "Test4Transactional1@domain.com", LocalDate.now());

        List<User> users = Arrays.asList(test1, test2, test3, test4);

        try{
            userService.saveTransactional(users);
        }catch (Exception e){
            LOGGER.error("Esta es una excepción dentro del metodo transaccional" + e);
        }

        userService.getAllUsers()
                .forEach(user -> LOGGER.info("Este es el usuario dentro del metodo transaccional " + user));
    }

    private void getInformationJpqlFromUser(){
        /*LOGGER.info(
                "Usuario con el metodo findByUserEmail " +  userRepository.findByUserEmail("julie@domain.com")
                        .orElseThrow(() -> new RuntimeException("No se encontro el usuario"))
        );

        userRepository.findAndSort("user", Sort.by("id").ascending())
                .forEach(user -> LOGGER.info("Usuario con metodo sort " + user));

        userRepository.findByName("John")
                .forEach(user -> LOGGER.info("Usuario con query method " + user.toString()));

        LOGGER.info(
                "Usuario con query method findByEmailAndName " + userRepository.findByEmailAndName("daniela@domain.com", "Daniela")
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        userRepository.findByNameLike("%J%")
                .forEach(user -> LOGGER.info("Usuario findByNameLike " + user));

        userRepository.findByNameOrEmail("user10", null)
                .forEach(user -> LOGGER.info("Usuario findByNameOrEmail " + user));*/

        userRepository.findByBirthDateBetween(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 4, 2))
                .forEach(user -> LOGGER.info("Usuario con intervalo de fechas: " + user));

        userRepository.findByNameContainingOrderByIdDesc("user")
                .forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado " + user));

        userRepository.findTop3ByNameLike("%user%")
                .forEach(user -> LOGGER.info("Usuario encontrado con like y limitado a 3 registros " + user));

        userRepository.findByBirthDateBefore(LocalDate.of(2021, 6, 1))
                .forEach(user -> LOGGER.info("Usuarios que cumplieron antes del 2021-06-01 " + user));
    }

    private void saveUserInDataBase(){
        User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 20));
        User user2 = new User("John", "julie@domain.com", LocalDate.of(2021, 5, 21));
        User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 7, 21));
        User user4 = new User("user4", "user5@domain.com", LocalDate.of(2021, 7, 7));
        User user5 = new User("user5", "user6@domain.com", LocalDate.of(2021, 11, 11));
        User user6 = new User("user6", "user7@domain.com", LocalDate.of(2021, 2, 25));
        User user7 = new User("user7", "user8@domain.com", LocalDate.of(2021, 3, 11));
        User user8 = new User("user8", "user4@domain.com", LocalDate.of(2021, 4, 12));
        User user9 = new User("user9", "user9@domain.com", LocalDate.of(2021, 5, 22));
        User user10 = new User("user10", "user10@domain.com", LocalDate.of(2021, 8, 3));
        User user11 = new User("user11", "user11@domain.com", LocalDate.of(2021, 1, 12));
        User user12 = new User("user12", "user12@domain.com", LocalDate.of(2021, 2, 2));
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        list.forEach(userRepository::save);
    }

    private void ejemplosAnteriores(){
        componentDependency.saludar(); myBean.print();
        myBeanWithDependency.printWithDependency();
        myMovimientoWithDependency.printEgress(3);

        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());

        try{
            int value = 10/0;
            LOGGER.debug("Hi valor: " + value);
        }catch (Exception e){
            LOGGER.error("Esto es un error al dividir por cero: " + e.getStackTrace());
        }
    }
}
