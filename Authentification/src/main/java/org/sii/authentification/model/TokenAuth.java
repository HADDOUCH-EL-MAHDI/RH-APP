package org.sii.authentification.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class TokenAuth {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "token")
    private String token;
    @Column(name = "email")
    private String email;
    @Column(name = "expired")
    private Boolean expired = false;
    @Column(name = "id_absence")
    private Integer idAbsence;
    @Column(name = "id_document")
    private Integer idDocument;


}
