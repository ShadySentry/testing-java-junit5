package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.VetModelImplementation;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {
    private SpecialtyService specialtyService;
    private VetController vetController;

    private Vet vet1;
    private Vet vet2;

    @BeforeEach
    void setUp() {
        VetMapService vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);


        vet1 = new Vet(1l,"Dave","Jenkins",null);
        vet2 = new Vet(2l,"John","Tomas", null);
        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVetsTest() {
        VetModelImplementation model = new VetModelImplementation();
        String requestResult= vetController.listVets(model);
        HashMap modelContent = (HashMap) model.map;
        HashSet vets = (HashSet) model.map.get("vets");
        assertTrue(model.map.containsKey("vets"), "Noe object with key \"vets\" found");
        assertEquals(2, vets.size());
        assertAll("vetController content test",
                ()->assertTrue(vets.contains(vet1),vet1.toString()),
                ()->assertTrue(vets.contains(vet2),vet2.toString()));
        assertEquals("vets/index", requestResult,"Wrong list request result");
    }


}
