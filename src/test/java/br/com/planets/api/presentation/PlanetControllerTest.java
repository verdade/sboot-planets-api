package br.com.planets.api.presentation;

import br.com.planets.api.DataBuilder;
import br.com.planets.api.PlanetTests;
import br.com.planets.api.facade.ApiClient;
import br.com.planets.api.facade.ResponseClient;
import br.com.planets.api.infrastructure.PlanetRepository;
import br.com.planets.api.models.PlanetRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PlanetControllerTest extends PlanetTests {

    @MockBean
    private ApiClient apiClient;
    @MockBean
    private PlanetRepository repository;
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String PATH = "/planets/v1";

    @Test
    public void mustCreatePlanetWithSuccess() throws Exception {
        ResponseClient responseClient = DataBuilder.getResponseClient();
        when(apiClient.getPlanet(anyLong())).thenReturn(responseClient);
        when(repository.save(any())).thenReturn(DataBuilder.getPlanet());
        PlanetRepresentation payload = DataBuilder.getDataPayloadEntyPlanet();
        final MvcResult result = buildPerformNewPlanet(payload)
                .andExpect(jsonPath("$.name", Matchers.is(payload.getName())))
                .andExpect(jsonPath("$.films", Matchers.is(2)))
                .andExpect(status().isCreated())
                .andReturn();
    }

//    @Test
    public void mustCreatePlanetWithError400() throws Exception {
        PlanetRepresentation payload = new PlanetRepresentation();
        final MvcResult result = buildPerformNewPlanet(payload)
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    private ResultActions buildPerformNewPlanet(PlanetRepresentation payload) throws Exception {
        return this.mockMvc.perform(post(PATH)
                        .content(convertToJson(payload))
                        .contentType(this.contentType))
                .andDo(MockMvcResultHandlers.print());
    }

    public static String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException var2) {
            throw new RuntimeException("Error converting object to JSON.", var2);
        }
    }
}
