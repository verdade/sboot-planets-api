package br.com.planets.api.converter;

import br.com.planets.api.domain.Planet;
import br.com.planets.api.models.PlanetRepresentation;
import br.com.planets.api.models.ResponseRepresentation;
import br.com.planets.api.util.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanetConverter {

    public ResponseRepresentation toRepresentation(Page<Planet> result) {
        ResponseRepresentation representation = new ResponseRepresentation();
        representation.setPage(result.getPageable().getPageNumber() + 1);
        representation.setTotalElements(result.getPageable().getPageSize());
        representation.setTotalPages(result.getTotalPages());
        representation.setElements(toAuditDtoList(result));
        return representation;
    }

    private List<PlanetRepresentation> toAuditDtoList(Page<Planet> result) {
       return result.map(model -> toDto(model)).getContent();
    }

    private PlanetRepresentation toDto(Planet model) {
        PlanetRepresentation representation = new PlanetRepresentation();
        if(model == null) {
            return null;
        }
        representation.setId(model.getId());
        representation.setName(model.getName());
        representation.setClimate(model.getClimate());
        representation.setTerrain(model.getTerrain());
        representation.setFilms(model.getFilms());
        if(model.getCreatedAt() != null) {
            representation.setFormattedDate(DateUtils.convertToString(model.getCreatedAt()));
            representation.setCreatedAt(model.getCreatedAt());
        }
        return representation;
    }


    public Planet toDomain(PlanetRepresentation payload) {
        return Planet.builder()
                .id(payload.getId())
                .name(payload.getName())
                .terrain(payload.getTerrain())
                .climate(payload.getClimate())
                .films(payload.getFilms())
                .build();
    }

    public PlanetRepresentation toPlanetRepresentation(Planet planet) {
        PlanetRepresentation representation = new PlanetRepresentation();
        representation.setId(planet.getId());
        representation.setName(planet.getName());
        representation.terrain(planet.getTerrain());
        representation.films(planet.getFilms());
        representation.setClimate(planet.getClimate());
        return representation;
    }
}
