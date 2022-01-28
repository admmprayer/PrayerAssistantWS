package com.admmprayergroup.assistant.modules.parish;

import com.admmprayergroup.assistant.modules.parish.dto.models.Parish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParishRepository extends CrudRepository<Parish, Long> {
}
