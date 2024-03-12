package org.sii.DemandesAdministratives.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemandesAdministrativesController {
    @GetMapping
    public String hello(){
        return "je suis DemandeAdministrative";
    }
}
