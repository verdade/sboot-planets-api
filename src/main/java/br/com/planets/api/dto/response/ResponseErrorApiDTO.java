package br.com.planets.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorApiDTO<T>  {
    private Integer code;
    private String message;
    private T content;
}