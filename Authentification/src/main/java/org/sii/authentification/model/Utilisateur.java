package org.sii.authentification.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import javax.persistence.*;



@Entity
@Getter
@Setter

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager", referencedColumnName = "id")
    private Utilisateur manager;
    private boolean firstTimeLogin = true;
    @Column(name = "hire_date")
    private LocalDate hireDate;

}
