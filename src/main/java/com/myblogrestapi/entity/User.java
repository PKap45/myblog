package com.myblogrestapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "user",
uniqueConstraints = {
        @UniqueConstraint( columnNames ={"username"}),
        @UniqueConstraint(columnNames = {"email"})
}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String email;

    private String name;

    private String password;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinTable( name="user_roles",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    private Set<Role> roles;




}
