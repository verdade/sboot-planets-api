package br.com.planets.api.presentation;

import br.com.planets.api.PlanetTests;
import br.com.planets.api.models.PlanetRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuditControllerTest extends PlanetTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String PATH = "/planets/v1";

    @Test
    public void mustCreatePlanetWithSuccess() throws Exception {
        PlanetRepresentation payload = new PlanetRepresentation();
        payload.setId(1L);
        payload.setName("Tatooine");
        payload.setTerrain("arid");
        payload.setClimate("Rain");
        final MvcResult result = buildPerformNewPlanet(payload)
                .andExpect(jsonPath("$.name", Matchers.is(payload.getName())))
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


//    @Test
//    public void mustReturnedByUserName() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.setUserName("Rodrigo");
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(jsonPath("$.elements[0].userName", Matchers.is("Rodrigo")))
//                .andExpect(status().isOk())
//                .andReturn();
//    }

//    @Test
//    public void mustReturnedByBranchId() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.branchIds(Arrays.asList("1"));
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(jsonPath("$.elements[0].branchId", Matchers.is("1")))
//                .andExpect(status().isOk())
//                .andReturn();
//    }
//
//    @Test
//    public void mustReturnedByActionType() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.setActionTypes(Arrays.asList("COCKPIT_PERMISSION_ORDER"));
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(jsonPath("$.elements[0].actionType", Matchers.is("COCKPIT_PERMISSION_ORDER")))
//                .andExpect(status().isOk())
//                .andReturn();
//    }


//    @Test
//    public void mustReturnedFullContract() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(jsonPath("$.elements[0].id", Matchers.is("1")))
//                .andExpect(jsonPath("$.elements[0].ip", Matchers.is("192.168.0.1")))
//                .andExpect(jsonPath("$.elements[0].companyId", Matchers.is("1")))
//                .andExpect(jsonPath("$.elements[0].branchName", Matchers.is("LJ Otavio Rocha")))
//                .andExpect(jsonPath("$.elements[0].plate", Matchers.is("1")))
//                .andExpect(jsonPath("$.elements[0].userName", Matchers.is("Rodrigo")))
//                .andExpect(jsonPath("$.elements[0].email", Matchers.is("email@email.com")))
//                .andExpect(jsonPath("$.elements[0].actionType", Matchers.is("COCKPIT_PERMISSION_ORDER")))
//                .andExpect(status().isOk())
//                .andReturn();
//    }


//    @Test
//    public void mustReturnedAll() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(status().isOk())
//                .andReturn();
//    }

//    @Test
//    public void mustReturnedAllBySecondPageBy3TotalElements() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.setPage(2);
//        payload.setTotalElements(3);
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(2)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(4)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(3)))
//                .andExpect(status().isOk())
//                .andReturn();
//    }

//    @Test
//    public void mustReturnedAllBySecondPageBy15TotalElements() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.setPage(2);
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(2)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(status().isOk())
//                .andReturn();
//    }

//    @Test
//    public void mustReturnedAllByFirstPageBy15TotalElements() throws Exception {
//        SearchPayloadRepresentation payload = new SearchPayloadRepresentation();
//        payload.setPage(1);
//        final MvcResult result = buildPerform(payload)
//                .andExpect(jsonPath("$.page", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalPages", Matchers.is(1)))
//                .andExpect(jsonPath("$.totalElements", Matchers.is(15)))
//                .andExpect(status().isOk())
//                .andReturn();
//    }



//    private ResultActions buildPerform(SearchPayloadRepresentation payload) throws Exception {
//        return this.mockMvc.perform(post(PATH)
//                        .content(convertToJson(payload))
//                        .contentType(this.contentType))
//                .andDo(MockMvcResultHandlers.print());
//    }



    public static String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException var2) {
            throw new RuntimeException("Error converting object to JSON.", var2);
        }
    }
}
