package com.isep.acme.bootstrapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.isep.acme.model.RoleUser;
import com.isep.acme.repositories.RoleUserRepository;

@Component
@Profile("bootstrap")
public class RoleUserBootstrapper implements CommandLineRunner {

    @Autowired
    RoleUserRepository roleUserRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // ArrayList<RoleUser> roleUserList = new ArrayList<>();

        // RoleUser roleManager = new RoleUser("Manager");
        // roleUserList.add(roleManager);
        
        // RoleUser roleAdmin = new RoleUser("Admin");
        // roleUserList.add(roleAdmin);
        
        // RoleUser roleDefault = new RoleUser("Default");
        // roleUserList.add(roleDefault);


        // roleUserRepository.saveAll(roleUserList);

    }

}
