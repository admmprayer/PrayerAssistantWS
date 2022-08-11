package com.admmprayergroup.assistant.prayerslots;

import com.admmprayergroup.assistant.prayerslots.dto.PrayerSlotDTO;
import com.admmprayergroup.assistant.prayerslots.exception.InsufficientParametersException;
import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.prayerslots.service.PrayerSlotService;
import com.admmprayergroup.assistant.prayerslots.vo.DateUtils;
import com.admmprayergroup.assistant.prayerslots.vo.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Objects;

@RequestMapping("v1/api/prayer/slot")
public class PrayerSlotBookingController {

    @Autowired
    private PrayerSlotService prayerSlotService;

    @GetMapping
    public ResponseEntity<PrayerSlotDTO> getPrayerSlot(@RequestParam(value = "date", required = false) LocalDate date,
                                                       @RequestParam(value = "count", required = false) Long dayCount) throws InsufficientParametersException {
        if (ValidatorUtils.isAnyNull(date, dayCount)) {
            throw new InsufficientParametersException();
        }
        PrayerSlotDTO prayerSlotDTO;
        prayerSlotDTO = prayerSlotService.getSlot(Objects.requireNonNullElseGet(date, () -> DateUtils.getDate(dayCount)));
        return ResponseEntity.ok(prayerSlotDTO);
    }

    @PostMapping
    public ResponseEntity<PrayerSlotDTO> createPrayerSlot(@RequestParam("date") LocalDate date, @RequestBody PrayerSlotDTO prayerSlotDTO) {
        PrayerSlotDTO newPrayerSlot = prayerSlotService.createSlot(date, prayerSlotDTO);
        return ResponseEntity.ok(newPrayerSlot);
    }

    @PatchMapping
    public ResponseEntity<Void> updatePrayerSlot(@RequestParam(value = "date", required = false) LocalDate date,
                                                 @RequestParam(value = "count", required = false) Long dayCount,
                                                 @RequestBody PrayerSlotDTO prayerSlotDTO) throws InsufficientParametersException, NotFoundInDatabaseException {
        if (ValidatorUtils.isAnyNull(date, dayCount) || ValidatorUtils.isAnyNull(prayerSlotDTO.getSaintSpeech(), prayerSlotDTO.getGeneralSpeech(), prayerSlotDTO.getGospel())) {
            throw new InsufficientParametersException();
        }
        prayerSlotService.updateSlot(Objects.requireNonNullElseGet(date, () -> DateUtils.getDate(dayCount)), prayerSlotDTO);
        return ResponseEntity.noContent().build();
    }

}
