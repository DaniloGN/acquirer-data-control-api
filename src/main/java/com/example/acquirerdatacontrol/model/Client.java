package com.example.acquirerdatacontrol.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "client")
    Set<Contract> establishment;

    public Client(String name) {
        this.name = name;
    }

    public Client(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContract_number() {
        if(establishment == null){
            return 0;
        }
        else {
            return establishment.size();
        }
    }
}
