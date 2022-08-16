package com.admmprayergroup.assistant.prayerslots.repository;

import com.admmprayergroup.assistant.prayerslots.PrayerSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrayerSlotRepository extends CrudRepository<PrayerSlot, Long> {
    Optional<PrayerSlot> findByDate(LocalDate date);
}
