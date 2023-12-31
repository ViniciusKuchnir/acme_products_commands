package com.isep.acme.bootstrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.model.Role;
import com.isep.acme.model.RoleUser;
import com.isep.acme.model.User;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.RoleUserRepository;
import com.isep.acme.repositories.UserRepository;

@Component
@Profile("bootstrap")
public class UserBootstrapper implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private ProductRepository pRepo;

    @Override
    public void run(String... args) throws Exception {
        RoleUser roleManager = new RoleUser("Manager");
        roleUserRepository.save(roleManager);

        RoleUser roleAdmin = new RoleUser("Admin");
        roleUserRepository.save(roleAdmin);

        RoleUser roleUserDefault = new RoleUser("Default");
        roleUserRepository.save(roleUserDefault);

        // admin
        if(userRepo.findByUsername("admin1@mail.com").isEmpty()) {
            User admin1 = new User("admin1@mail.com", encoder.encode("AdminPW1"),
                    "Jose Antonio", "355489123", "Rua Um", roleManager);
            admin1.addAuthority(new Role(Role.Admin));
            userRepo.save(admin1);

             if (pRepo.findBySku("asd578fgh267").isEmpty()) {
                 Product p1 = new Product("asd578fgh267", "Pen", "very good nice product", admin1);
                 pRepo.save(p1);
             }
         }

        if(userRepo.findByUsername("admin2@mail.com").isEmpty()) {
            User admin2 = new User("admin2@mail.com", encoder.encode("AdminPW2"),
                    "Vinícius Kuchnir", "111111111", "Rua Arquitetura de Software", roleManager);
            admin2.addAuthority(new Role(Role.Admin));
            userRepo.save(admin2);

             if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
                 Product p2 = new Product("c1d4e7r8d5f2", "Pencil", " writes", admin2);
                 pRepo.save(p2);
             }
        }

        User admin3 = new User("admin3@mail.com", encoder.encode("AdminPW3"),
                    "Vinícius Kuchnir", "444444444", "Rua Arquitetura de Software II", roleManager);
            admin3.addAuthority(new Role(Role.Admin));
            userRepo.save(admin3);

        User user1 = new User("user1@mail.com", encoder.encode("UserPW1"),
                    "Vinícius Kuchnir", "333333333", "Rua Arquitetura de Software", roleUserDefault);
            user1.addAuthority(new Role(Role.Admin));
            userRepo.save(user1);

        // if(userRepo.findByUsername("admin1@mail.com").isEmpty()) {
        //     User admin1 = new User("admin1@mail.com", encoder.encode("AdminPW1"),
        //             "Jose Antonio", "355489123", "Rua Um", roleManager);
        //     admin1.setRole(roleManager);
        //     admin1.addAuthority(new Role(Role.Admin));
        //     userRepo.save(admin1);

        //     if (pRepo.findBySku("asd578fgh267").isEmpty()) {
        //         Product p1 = new Product("asd578fgh267", "Pen", "very good nice product", admin1);
        //         pRepo.save(p1);
        //     }
        // }

        // if(userRepo.findByUsername("admin2@mail.com").isEmpty()) {
        //     User mod1 = new User("admin2@mail.com", encoder.encode("AdminPW2"),
        //             "Antonio Jose", "321984553", "Rua dois", roleAdmin);
        //     mod1.setRole(roleAdmin);
        //     mod1.addAuthority(new Role(Role.Mod));
        //     userRepo.save(mod1);

        //     if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
        //         Product p2 = new Product("c1d4e7r8d5f2", "Pencil", " writes", mod1);
        //         pRepo.save(p2);
        //     }
        // }

        // if(userRepo.findByUsername("user1@mail.com").isEmpty()) {
        //     User user1 = new User("user1@mail.com", encoder.encode("userPW1"),
        //             "Nuno Miguel", "253647883", "Rua tres", roleUserDefault);
        //     user1.setRole(roleUserDefault);
        //     user1.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user1);

        //     if (pRepo.findBySku("c4d4f1v2f5v3").isEmpty()) {
        //         Product p3 = new Product("c4d4f1v2f5v3", "Rubber", "erases", user1);
        //         pRepo.save(p3);
        //     }
        // }

        // if(userRepo.findByUsername("user2@mail.com").isEmpty()) {
        //     User user2 = new User("user2@mail.com", encoder.encode("userPW2"),
        //             "Miguel Nuno", "253698854", "Rua quatro", roleUserDefault);
        //     user2.setRole(roleUserDefault);
        //     user2.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user2);

        //     if (pRepo.findBySku("v145dc2365sa").isEmpty()) {
        //         Product p4 = new Product("v145dc2365sa", "Wallet", "stores money", user2);
        //         pRepo.save(p4);
        //     }

        // }

        // if(userRepo.findByUsername("user3@mail.com").isEmpty()) {
        //     User user3 = new User("user3@mail.com", encoder.encode("userPW3"),
        //             "Antonio Pedro", "254148863", "Rua vinte", roleUserDefault);
        //     user3.setRole(roleUserDefault);
        //     user3.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user3);

        //     if (pRepo.findBySku("fg54vc14tr78").isEmpty()) {
        //         Product p5 = new Product("fg54vc14tr78", "pencil case", " stores pencils", user3);
        //         pRepo.save(p5);
        //     }
        // }

        // if(userRepo.findByUsername("user4@mail.com").isEmpty()) {
        //     User user4 = new User("user4@mail.com", encoder.encode("userPW4"),
        //             "Pedro Antonio", "452369871", "Rua cinco", roleUserDefault);
        //             user4.setRole(roleUserDefault);
        //     user4.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user4);
        // }

        // if(userRepo.findByUsername("user5@mail.com").isEmpty()) {
        //     User user5 = new User("user5@mail.com", encoder.encode("userPW5"),
        //             "Ricardo Joao", "452858596", "Rua seis", roleUserDefault);
        //     user5.setRole(roleUserDefault);
        //     user5.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user5);

        //     if (pRepo.findBySku("12563dcfvg41").isEmpty()) {
        //         Product p6 = new Product("12563dcfvg41", "Glasses case", " stores glasses", user5);
        //         pRepo.save(p6);
        //     }
        // }
        // if(userRepo.findByUsername("user6@mail.com").isEmpty()) {
        //     User user6 = new User("user6@mail.com", encoder.encode("userPW6"),
        //             "Joao Ricardo", "425364781", "Rua sete", roleUserDefault);
        //     user6.setRole(roleUserDefault);
        //     user6.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user6);

        //     if (pRepo.findBySku("vcg46578vf32").isEmpty()) {
        //         Product p7 = new Product("vcg46578vf32", "tissues", " nose clearing material", user6);
        //         pRepo.save(p7);
        //     }
        // }
        // if(userRepo.findByUsername("user7@mail.com").isEmpty()) {
        //     User user7 = new User("user7@mail.com", encoder.encode("userPW7"),
        //             "Luis Pedro", "526397747", "Rua oito", roleUserDefault);
        //     user7.setRole(roleUserDefault);
        //     user7.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user7);
        // }


        // if(userRepo.findByUsername("user8@mail.com").isEmpty()) {
        //     User user8 = new User("user8@mail.com", encoder.encode("userPW8"),
        //             "Pedro Luis", "523689471", "Rua nove", roleUserDefault);
        //     user8.setRole(roleUserDefault);
        //     user8.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user8);

        //     if (pRepo.findBySku("vgb576hgb675").isEmpty()) {
        //         Product p8 = new Product("vgb576hgb675", "mouse pad", " mouse adapted surface", user8);
        //         pRepo.save(p8);
        //     }

        // }
        // if(userRepo.findByUsername("user9@mail.com").isEmpty()) {
        //     User user9 = new User("user9@mail.com", encoder.encode("userPW9"),
        //             "Marco Antonio", "253148965", "Rua dez", roleUserDefault);
        //     user9.setRole(roleUserDefault);
        //     user9.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user9);
        // }
        // if(userRepo.findByUsername("user10@mail.com").isEmpty()) {
        //     User user10 = new User("user10@mail.com", encoder.encode("userPW10"),
        //             "Antonio Marco", "201023056", "Rua onze", roleUserDefault);
        //     user10.setRole(roleUserDefault);
        //     user10.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user10);
        // }
        // if(userRepo.findByUsername("user11@mail.com").isEmpty()) {
        //     User user11 = new User("user11@mail.com", encoder.encode("userPW11"),
        //             "Rui Ricardo", "748526326", "Rua doze", roleUserDefault);
        //     user11.setRole(roleUserDefault);
        //     user11.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user11);
        // }

        // if(userRepo.findByUsername("admin3@mail.com").isEmpty()) {
        //     User user11 = new User("admin3@mail.com", encoder.encode("AdminPW3"),
        //             "Vinícius Kuchnir", "123456789", "Rua ISEP", roleUserDefault);
        //     user11.setRole(roleManager);
        //     user11.addAuthority(new Role(Role.RegisteredUser));
        //     userRepo.save(user11);
        // }

    }

}
