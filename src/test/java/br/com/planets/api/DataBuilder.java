package br.com.planets.api;

import br.com.planets.api.domain.Planet;
import br.com.planets.api.facade.ResponseClient;
import br.com.planets.api.models.PlanetRepresentation;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {


    public static ResponseClient getResponseClient() {
        List<String> films = new ArrayList<>();
        films.add("Film1");
        films.add("Film2");
        return   ResponseClient.builder()
                .name("Naboo")
                .terrain("grassy hills, swamps, forests, mountains")
                .climate("temperate")
                .films(films)
                .build();
    }

    public static PlanetRepresentation getDataPayloadEntyPlanet() {
        PlanetRepresentation representation = new PlanetRepresentation();
        representation.setId(12L);
        representation.setName("Naboo");
        representation.setTerrain("grassy hills, swamps, forests, mountains");
        representation.setClimate("temperate");
        return representation;
    }

    public static Planet getPlanet() {
        return Planet.builder()
                .id(12L)
                .name("Naboo")
                .films(2)
                .build();
    }
}


