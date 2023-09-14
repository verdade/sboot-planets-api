package br.com.planets.api.presentation;

import br.com.planets.api.models.PayloadSearchRepresentation;
import br.com.planets.api.models.PlanetRepresentation;
import br.com.planets.api.models.ResponseRepresentation;
import br.com.planets.api.representation.PlanetsApi;
import br.com.planets.api.service.PlanetService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping
@Validated
@Slf4j
public class PlanetController implements PlanetsApi {

    private PlanetService service;

        @Override
    public ResponseEntity<ResponseRepresentation> searchPlanets(@Valid @RequestBody(required = false) PayloadSearchRepresentation payload) {
        log.info("..: Init Search Planets: {} ", payload.toString());
        return ResponseEntity.status(HttpStatus.OK).body(service.search(payload));
    }

    @Override
    public ResponseEntity<PlanetRepresentation> newPlanet(PlanetRepresentation payload) {
        log.info("..: Init New Planet: {} ", payload.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(payload));
    }

    @Override
    public ResponseEntity<PlanetRepresentation> deletePlanet(@PathVariable("planetId") Long planetId) {
        log.info("..: Init Delete Planet: {} ", planetId);
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(planetId));
    }

}
