package br.com.planets.api.dto.request;

import br.com.planets.api.models.PayloadSearchRepresentation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
public class Pagination {

    private static final Integer DEFAULT_TOTAL_ELEMENTS = 15;

    @Min(1)
    private Integer page;

    @Min(1)
    @Max(3)
    private Integer totalElements;

    private Integer totalPages;

    public Pagination(PayloadSearchRepresentation payload) {
        this.page = payload.getPage() == null ? 1 : payload.getPage();
        this.totalElements = payload.getTotalElements() == null ? DEFAULT_TOTAL_ELEMENTS : payload.getTotalElements();
        this.totalPages = payload.getTotalPages();
    }
    public Integer getTotalElements() {
        return totalElements == null ? DEFAULT_TOTAL_ELEMENTS : totalElements;
    }
    public Integer getPage() {
        return page == null ? 0 : page - 1;
    }
}
