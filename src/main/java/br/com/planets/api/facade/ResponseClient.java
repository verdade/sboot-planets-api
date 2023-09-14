package br.com.planets.api.facade;

import lombok.Data;

import java.util.List;

@Data
public class ResponseClient {
    private String name;
    private String climate;
    private String terrain;
    private List<String> films;
}
