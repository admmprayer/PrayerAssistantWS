package com.admmprayergroup.assistant.prayerslots.service;

import com.admmprayergroup.assistant.prayerslots.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.prayerslots.PrayerSlot;
import com.admmprayergroup.assistant.prayerslots.repository.PrayerSlotRepository;
import com.admmprayergroup.assistant.prayerslots.vo.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrayerSlotServiceImplTest {

    @InjectMocks
    private PrayerSlotServiceImpl service;

    @Mock
    private PrayerSlotServiceImpl serviceMocked;

    @Mock
    private PrayerSlotRepository repository;

    private final String sampleString = "sample";
    private final LocalDate today = LocalDate.now();

    @Test
    void shouldReturnExistingSlot() {
        PrayerSlot samplePrayerSlot = getSamplePrayerSlot();

        when(repository.findByDate(today)).thenReturn(Optional.of(samplePrayerSlot));
        PrayerSlotDTO prayerSlot = service.getSlot(today);

        assertEqual(samplePrayerSlot, prayerSlot);
    }

    @Test
    void shouldReturnNewSlot() {
        PrayerSlot samplePrayerSlot = getSamplePrayerSlot();

        when(repository.findByDate(today)).thenReturn(Optional.empty());
        when(repository.save(any(PrayerSlot.class))).thenReturn(samplePrayerSlot);
        PrayerSlotDTO prayerSlot = service.getSlot(today);

        assertEqual(samplePrayerSlot, prayerSlot);
    }

    @Test
    void shouldCreateSlot() {
        PrayerSlot samplePrayerSlot = getSamplePrayerSlot();

        when(repository.save(any(PrayerSlot.class))).thenReturn(samplePrayerSlot);
        PrayerSlotDTO prayerSlot = service.createSlot(today, getSamplePrayerDTO());

        assertEqual(samplePrayerSlot, prayerSlot);
    }

    @Test
    void shouldUpdateSlot() {
        when(repository.findByDate(today)).thenReturn(Optional.of(getSamplePrayerSlot()));

        assertDoesNotThrow(() -> service.updateSlot(today, getSamplePrayerDTO()));
        assertDoesNotThrow(() -> service.updateSlot(today, new PrayerSlotDTO()));
    }

    @Test
    void shouldThrowNotFoundInDatabaseExceptionWhenSlotIsNotAvailable() {
        when(repository.findByDate(today)).thenReturn(Optional.empty());

        assertEquals("Requested data not found from interface com.admmprayergroup.assistant.prayerslots.repository.PrayerSlotRepository", assertThrows(
                NotFoundInDatabaseException.class,
                () -> service.updateSlot(today, getSamplePrayerDTO())
        ).getMessage());
    }

    private void assertEqual(PrayerSlot samplePrayerSlot, PrayerSlotDTO prayerSlot) {
        assertEquals(samplePrayerSlot.getDate(), prayerSlot.getDate());
        assertEquals(samplePrayerSlot.getDayCount(), prayerSlot.getDayCount());
        assertEquals(samplePrayerSlot.getSaintSpeech(), prayerSlot.getSaintSpeech());
        assertEquals(samplePrayerSlot.getGeneralSpeech(), prayerSlot.getGeneralSpeech());
        assertEquals(samplePrayerSlot.getGospel(), prayerSlot.getGospel());
    }

    private PrayerSlot getSamplePrayerSlot() {
        PrayerSlot prayerSlot = new PrayerSlot();
        prayerSlot.setId(1L);
        prayerSlot.setDate(today);
        prayerSlot.setDayCount(DateUtils.getDayCount(today));
        prayerSlot.setSaintSpeech(sampleString);
        prayerSlot.setGeneralSpeech(sampleString);
        prayerSlot.setGospel(sampleString);
        return prayerSlot;
    }

    private PrayerSlotDTO getSamplePrayerDTO() {
        return new PrayerSlotDTO().fromEntity(getSamplePrayerSlot());
    }

}
