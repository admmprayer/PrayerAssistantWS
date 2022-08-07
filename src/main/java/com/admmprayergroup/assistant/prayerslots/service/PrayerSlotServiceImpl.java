package com.admmprayergroup.assistant.prayerslots.service;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.models.PrayerSlot;
import com.admmprayergroup.assistant.prayerslots.repository.PrayerSlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrayerSlotServiceImpl implements PrayerSlotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrayerSlotServiceImpl.class);

    @Autowired
    private PrayerSlotRepository prayerSlotRepository;

    @Override
    public PrayerSlotDTO getSlot(LocalDate date) {
        Optional<PrayerSlot> prayerSlot = prayerSlotRepository.findByDate(date);
        if (prayerSlot.isPresent()) {
            LOGGER.info("Prayer slot available in requested date");
            return new PrayerSlotDTO().fromEntity(prayerSlot.get());
        }
        LOGGER.info("Prayer slot not available in requested date. Creating a new one...");
        return createSlot(date);
    }

    @Override
    public PrayerSlotDTO createSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO) {
        PrayerSlot newPrayerSlot = prayerSlotRepository.save(prayerSlotDTO.toEntity(date));
        LOGGER.info("Successfully created a new prayer slot");
        return prayerSlotDTO.fromEntity(newPrayerSlot);
    }

    private PrayerSlotDTO createSlot(LocalDate date) {
        PrayerSlotDTO prayerSlotDTO = new PrayerSlotDTO(date);
        return createSlot(date, prayerSlotDTO);
    }

    @Override
    public void updateSlot(LocalDate date, PrayerSlotDTO prayerSlotDTO) {
        Optional<PrayerSlot> prayerSlotOptional = prayerSlotRepository.findByDate(date);
        if (prayerSlotOptional.isPresent()) {
            PrayerSlot prayerSlot = prayerSlotOptional.get();
            if (prayerSlotDTO.getSaintSpeech() != null) {
                prayerSlot.setSaintSpeech(prayerSlotDTO.getSaintSpeech());
                LOGGER.info("updating saint speech...");
            }
            if (prayerSlotDTO.getGeneralSpeech() != null) {
                prayerSlot.setGeneralSpeech(prayerSlotDTO.getGeneralSpeech());
                LOGGER.info("updating general speech...");
            }
            if (prayerSlotDTO.getGospel() != null) {
                prayerSlot.setGospel(prayerSlotDTO.getGospel());
                LOGGER.info("updating gospel...");
            }
            prayerSlotRepository.save(prayerSlot);
            LOGGER.info("Successfully updated prayer slot");
        }
        // TODO: Throw an exception: cant update unavailable prayer slot
    }

}
