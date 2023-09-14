package br.com.planets.api.dto.request;

import com.querydsl.core.types.Predicate;

public interface PredicateQueryFilter {
    Predicate build();
}
