package br.com.planets.api.facade;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseClient {
    private String name;
    private String climate;
    private String terrain;
    private List<String> films;
}
