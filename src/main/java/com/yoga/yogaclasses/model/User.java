package com.yoga.yogaclasses.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String email;

    private String password;

    private int yogaTime;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    public User(String name, int age, String email, String password,int yogaTime,Date date, Collection<Role> roles) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.yogaTime=yogaTime;
        this.date=date;
        this.roles=roles;
    }
    public Collection < Role > getRoles() {
        return roles;
    }
    public void setRoles(Collection < Role > roles) {
        this.roles = roles;
    }
}
