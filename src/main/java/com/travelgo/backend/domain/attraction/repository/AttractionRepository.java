package com.travelgo.backend.domain.attraction.repository;

import com.travelgo.backend.domain.attraction.entity.Attraction;
import com.travelgo.backend.domain.attraction.model.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    Attraction findByAttractionName(String name);

    List<Attraction> findAllByArea(AreaCode areaCode);
}
