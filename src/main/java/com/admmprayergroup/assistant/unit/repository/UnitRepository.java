package com.admmprayergroup.assistant.unit.repository;

import com.admmprayergroup.assistant.unit.models.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {

    Optional<Unit> findByRegisteredId(String registeredId);

}
