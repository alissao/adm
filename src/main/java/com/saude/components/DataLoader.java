package com.saude.components;

import com.saude.domain.Admin;
import com.saude.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    @Autowired
    private AdminRepository admRepository;

    @PostConstruct
    public void initialUsers() {
        Admin adm = new Admin();
        adm.setUsername("Doutor");
        adm.setPassword("doutor1234");
        adm.setEmail("doutor@consultorio");

        Admin adm2 = new Admin();
        adm.setUsername("Enfermeira");
        adm.setPassword("enfermeira1234");
        adm.setEmail("enfermeira@consultorio");

        List<Admin> admins = new ArrayList<Admin>();
        admins.add(adm);
        admins.add(adm2);

        admRepository.saveAll(admins);
    }

}
