package com.admmprayergroup.assistant.prayerslots;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.exception.InsufficientParametersException;
import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.prayerslots.service.PrayerSlotService;
import com.admmprayergroup.assistant.prayerslots.vo.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrayerSlotBookingControllerTest {

    @InjectMocks
    private PrayerSlotBookingController controller;

    @Mock
    private PrayerSlotService prayerSlotService;

    private final String sampleString = "sample";
    private final LocalDate today = LocalDate.now();

    @Test
    void shouldReturnPrayerSlotsForDate_getPrayerSlot() throws InsufficientParametersException {
        PrayerSlotDTO prayerSlotDTO = getSamplePrayerSlot(today);

        when(prayerSlotService.getSlot(any(LocalDate.class))).thenReturn(prayerSlotDTO);
        ResponseEntity<PrayerSlotDTO> response = controller.getPrayerSlot(today, null);

        verify(prayerSlotService, times(1)).getSlot(any(LocalDate.class));
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        PrayerSlotDTO responseBody = response.getBody();
        assertEquals(PrayerSlotDTO.class, responseBody.getClass());
        assertEquals(today, responseBody.getDate());
        assertEquals(DateUtils.getDayCount(today), responseBody.getDayCount());
        assertEquals(sampleString, responseBody.getSaintSpeech());
        assertEquals(sampleString, responseBody.getGeneralSpeech());
        assertEquals(sampleString, responseBody.getGospel());
    }

    @Test
    void shouldReturnPrayerSlotsForDayCount_getPrayerSlot() throws InsufficientParametersException {
        LocalDate firstDay = LocalDate.of(2021, 5, 24);
        PrayerSlotDTO prayerSlotDTO = getSamplePrayerSlot(firstDay);

        when(prayerSlotService.getSlot(any(LocalDate.class))).thenReturn(prayerSlotDTO);
        ResponseEntity<PrayerSlotDTO> response = controller.getPrayerSlot(null, 1L);

        verify(prayerSlotService, times(1)).getSlot(any(LocalDate.class));
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        PrayerSlotDTO responseBody = response.getBody();
        assertEquals(PrayerSlotDTO.class, responseBody.getClass());
        assertEquals(firstDay, responseBody.getDate());
        assertEquals(1L, responseBody.getDayCount());
        assertEquals(sampleString, responseBody.getSaintSpeech());
        assertEquals(sampleString, responseBody.getGeneralSpeech());
        assertEquals(sampleString, responseBody.getGospel());
    }

    @Test
    void shouldThrowInsufficientParametersException_getPrayerSlot() {
        assertThrows(InsufficientParametersException.class, () -> controller.getPrayerSlot(null, null));
    }

    @Test
    void shouldReturnSavedPrayer_createPrayerSlot() {
        PrayerSlotDTO prayerSlotDTO = getSamplePrayerSlot(today);

        when(prayerSlotService.createSlot(eq(today), any(PrayerSlotDTO.class))).thenReturn(prayerSlotDTO);
        ResponseEntity<PrayerSlotDTO> response = controller.createPrayerSlot(today, prayerSlotDTO);

        verify(prayerSlotService, times(1)).createSlot(eq(today), any(PrayerSlotDTO.class));
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        PrayerSlotDTO responseBody = response.getBody();
        assertEquals(PrayerSlotDTO.class, responseBody.getClass());
        assertEquals(today, responseBody.getDate());
        assertEquals(DateUtils.getDayCount(today), responseBody.getDayCount());
        assertEquals(sampleString, responseBody.getSaintSpeech());
        assertEquals(sampleString, responseBody.getGeneralSpeech());
        assertEquals(sampleString, responseBody.getGospel());
    }

    @Test
    void shouldUpdatePrayerSlotByDate() throws NotFoundInDatabaseException, InsufficientParametersException {
        PrayerSlotDTO prayerSlotDTO = getSamplePrayerSlot(today);

        doNothing().when(prayerSlotService).updateSlot(eq(today), any(PrayerSlotDTO.class));
        controller.updatePrayerSlot(today, null, prayerSlotDTO);
        verify(prayerSlotService, times(1)).updateSlot(eq(today), any(PrayerSlotDTO.class));
    }

    @Test
    void shouldUpdatePrayerSlotByDayCount() throws NotFoundInDatabaseException, InsufficientParametersException {
        LocalDate prayerStartedDate = LocalDate.of(2021, 5, 24);
        PrayerSlotDTO prayerSlotDTO = getSamplePrayerSlot(prayerStartedDate);

        doNothing().when(prayerSlotService).updateSlot(eq(prayerStartedDate), any(PrayerSlotDTO.class));
        controller.updatePrayerSlot(null, 1L, prayerSlotDTO);
        verify(prayerSlotService, times(1)).updateSlot(eq(prayerStartedDate), any(PrayerSlotDTO.class));
    }

    @Test
    void shouldThrowInsufficientParametersException_whenDateAndDayCountNotPassed() {
        assertThrows(InsufficientParametersException.class, () -> controller.updatePrayerSlot(null, null, getSamplePrayerSlot(today)));
    }

    @Test
    void shouldThrowInsufficientParametersException_whenUpdateContentNotPassed() {
        assertThrows(InsufficientParametersException.class, () -> controller.updatePrayerSlot(today, null, new PrayerSlotDTO()));
    }

    @Test
    void shouldThrowInsufficientParametersException_whenDateAndDayCountAndUpdateContentNotPassed() {
        assertThrows(InsufficientParametersException.class, () -> controller.updatePrayerSlot(null, null, new PrayerSlotDTO()));
    }

    private PrayerSlotDTO getSamplePrayerSlot(LocalDate date) {
        PrayerSlotDTO prayerSlotDTO = new PrayerSlotDTO(date);
        prayerSlotDTO.setSaintSpeech(sampleString);
        prayerSlotDTO.setGeneralSpeech(sampleString);
        prayerSlotDTO.setGospel(sampleString);
        return prayerSlotDTO;
    }

}
