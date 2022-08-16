package com.admmprayergroup.assistant.unit.diocese.repository;

import com.admmprayergroup.assistant.unit.diocese.dto.DioceseTag;
import com.admmprayergroup.assistant.unit.diocese.models.Diocese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DioceseRepository extends CrudRepository<Diocese, Long> {

    List<Diocese> findByTag(DioceseTag dioceseTag);

}
