package com.admmprayergroup.assistant.prayerslots;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.exception.InsufficientParametersException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrayerSlotBookingControllerTest {

    @InjectMocks
    private PrayerSlotBookingController controller;

    @Mock
    private PrayerSlotService prayerSlotService;

    private final String sampleString = "sample";

    @Test
    void shouldReturnPrayerSlotsForDate() throws InsufficientParametersException {
        LocalDate today = LocalDate.now();
        PrayerSlotDTO prayerSlotDTO = new PrayerSlotDTO(today);
        prayerSlotDTO.setSaintSpeech(sampleString);
        prayerSlotDTO.setGeneralSpeech(sampleString);
        prayerSlotDTO.setGospel(sampleString);

        when(prayerSlotService.getSlot(any(LocalDate.class))).thenReturn(prayerSlotDTO);
        ResponseEntity<PrayerSlotDTO> response = controller.getPrayerSlot(today, null);

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

}
