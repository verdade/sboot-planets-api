package br.com.planets.api.infrastructure;

import br.com.planets.api.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>, QuerydslPredicateExecutor<Planet> {
}
