package com.admmprayergroup.assistant.modules.parish;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParishRepository extends CrudRepository<Parish, Long> {
}
