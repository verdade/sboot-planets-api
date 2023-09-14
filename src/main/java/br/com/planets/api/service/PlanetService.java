package br.com.planets.api.service;

import br.com.planets.api.converter.PlanetConverter;
import br.com.planets.api.domain.Planet;
import br.com.planets.api.dto.request.Pagination;
import br.com.planets.api.dto.request.SearchFilterPlanet;
import br.com.planets.api.exception.NotFoundException;
import br.com.planets.api.facade.ApiClient;
import br.com.planets.api.facade.ResponseClient;
import br.com.planets.api.infrastructure.PlanetRepository;
import br.com.planets.api.models.PayloadSearchRepresentation;
import br.com.planets.api.models.PlanetRepresentation;
import br.com.planets.api.models.ResponseRepresentation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class PlanetService {

    private PlanetRepository repository;
    private PlanetConverter converter;
    private ApiClient apiClient;

    public ResponseRepresentation search(PayloadSearchRepresentation payload) {
        SearchFilterPlanet filter = new SearchFilterPlanet(payload);
        Pagination pagination = new Pagination(payload);
        Page<Planet> result = getAll(filter, pagination);
        log.info("..: Finish Search Planet");
        return converter.toRepresentation(result);
    }

    private Page<Planet> getAll(@Valid SearchFilterPlanet filter, Pagination pagination) {
        return repository.findAll(filter.build(), filter.getPageRequest(pagination));
    }

    public PlanetRepresentation save(PlanetRepresentation payload) {
        ResponseClient responseClient = apiClient.getPlanet(payload.getId());
        if(responseClient != null) {
            payload.setTerrain(responseClient.getTerrain());
            payload.setClimate(responseClient.getClimate());
            payload.setFilms(responseClient.getFilms().size());
        }
        return converter.toPlanetRepresentation(repository.save(converter.toDomain(payload)));
    }

    public PlanetRepresentation delete(Long planetId) {
        Optional<Planet> planet = Optional.ofNullable(repository.findById(planetId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(planetId))));
        repository.delete(planet.get());
        return converter.toPlanetRepresentation(planet.get());
    }
}
