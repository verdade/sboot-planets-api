package br.com.planets.api.dto.request;

import br.com.planets.api.domain.QPlanet;
import br.com.planets.api.models.PayloadSearchRepresentation;
import br.com.planets.api.models.PayloadSearchRepresentation;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class SearchFilterPlanet implements PredicateQueryFilter {

    private Long id;
    private String name;
    private String climate;
    private String land;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate initDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'")
    private LocalDate finishDate;

    public SearchFilterPlanet(PayloadSearchRepresentation payload) {
        this.id = payload.getId();
        this.name = payload.getName();
    }

    private Map<String, String> fields = new HashMap<>();

    @Override
    public Predicate build() {
        BooleanBuilder builder = new BooleanBuilder();
        if(getId() != null) {
            builder.and(QPlanet.planet.id.eq(getId()));
            fields.put("Id", getId().toString());
        }
        if(StringUtils.isNotBlank(getName())) {
            builder.and(QPlanet.planet.name.eq(getName()));
            fields.put("Name", getName());
        }

        return builder;
    }

    public Pageable getPageRequest(Pagination pagination) {
        return PageRequest.of(pagination.getPage(), pagination.getTotalElements(), Sort.Direction.ASC, "id");
    }

}
