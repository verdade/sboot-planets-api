package br.com.planets.api.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "swapi-api", url = "https://swapi.dev/api")
public interface ApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/planets/{planetId}")
    ResponseClient getPlanet(@PathVariable("planetId") Long planetId);

}