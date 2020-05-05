package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {
    VetMapService vetService;
    SpecialtyService specialtyService;
    @BeforeEach
    void setUP(){
        vetService = new VetMapService(specialtyService);
    }


    @Test
    void listVets() {
    }
}