package com.admmprayergroup.assistant.unit.diocese.service;

import com.admmprayergroup.assistant.prayerslots.exception.NotFoundInDatabaseException;
import com.admmprayergroup.assistant.prayerslots.repository.PrayerSlotRepository;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseDTO;
import com.admmprayergroup.assistant.unit.diocese.dto.DioceseTag;
import com.admmprayergroup.assistant.unit.diocese.models.Diocese;
import com.admmprayergroup.assistant.unit.diocese.repository.DioceseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DioceseServiceImpl implements DioceseService {

    @Autowired
    private DioceseRepository repository;

    @Override
    public DioceseDTO get(Long id) throws NotFoundInDatabaseException {
        Optional<Diocese> optionalDiocese = repository.findById(id);
        if (optionalDiocese.isPresent()) {
            Diocese diocese = optionalDiocese.get();
            return new DioceseDTO().fromEntity(diocese);
        }
        throw new NotFoundInDatabaseException(DioceseServiceImpl.class);
    }

    @Override
    public List<DioceseDTO> get(DioceseTag dioceseTag) {
        List<Diocese> dioceseUnits = repository.findByTag(dioceseTag);
        return dioceseUnits.stream().map(diocese -> new DioceseDTO().fromEntity(diocese))
                .collect(Collectors.toCollection(() -> new ArrayList<>(dioceseUnits.size())));
    }

    @Override
    public DioceseDTO create(DioceseDTO diocese) {
        Diocese savedDiocese = repository.save(diocese.toEntity());
        return diocese.fromEntity(savedDiocese);
    }

}
