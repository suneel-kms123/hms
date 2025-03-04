package com.hms.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FacilityRepository extends JpaRepository<Facilities, Long> {
    Optional<Facilities> findByCityInAndStreetIn(Collection<String> cities, Collection<String> streets);
}
