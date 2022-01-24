package com.admmprayergroup.assistant.modules.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<ArchdiocesanGroup, Long> {
}
