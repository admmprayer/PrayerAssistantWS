package com.admmprayergroup.assistant.vo;

import com.admmprayergroup.assistant.dto.models.PrayerSlot;
import com.britsa.commons.codes.ApplicationCodes;
import com.britsa.commons.codes.HTTPCodes;
import com.britsa.commons.exceptions.WebExceptionType;
import com.britsa.commons.exceptions.WebServiceException;
import com.britsa.commons.misc.FirebaseServer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class FirestoreDocument {

    @Value("${firestore.database.url}")
    private String databaseURL;

    @Value("${firestore.database.credentials}")
    private String databaseSecret;

    private Firestore db;

    public static final String COLLECTION_PRAYER_SLOT = "prayer_slot";

    // COLLECTION: PRAYER_SLOT
    public static final String DOC_CELEBRATE_ID = "celebrate_id";
    public static final String DOC_DATE = "date";

    public Firestore getDB() throws Exception {
        if (this.db == null)
            this.db = FirebaseServer.start().initialize(databaseURL, databaseSecret);
        return this.db;
    }

    public List<PrayerSlot> retrieveNextFourSlots() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        LocalDate today = LocalDate.now(ZoneId.of("Australia/Lord_Howe"));
        List<PrayerSlot> prayerSlotList = new LinkedList<>();
        for (int day = 0; day < 4; day++) {
            String documentID = simpleDateFormat.format(today.plus(day, ChronoUnit.DAYS));
            PrayerSlot prayerSlot = this.retrieve(FirestoreDocument.COLLECTION_PRAYER_SLOT, documentID, PrayerSlot.class);
            prayerSlotList.add(prayerSlot);
        }
        return prayerSlotList;
    }

    public void save(String collectionName, String documentID, Object object) throws Exception {
        ApiFuture<WriteResult> apiFuture = getDB().collection(collectionName).document(documentID).set(object);
    }

    public void update(String collectionName, String documentID, Object object) throws Exception {
        ApiFuture<WriteResult> apiFuture = getDB().collection(collectionName).document(documentID).update((Map<String, Object>) object);
    }

    public <T> T retrieve(String collectionName, String documentID, Class<T> classType) throws Exception {
        DocumentSnapshot document = getDB().collection(collectionName).document(documentID).get().get();

        boolean idAvailable = document.exists();

        if (idAvailable) {
            return document.toObject(classType);
        } else {
            throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_NOT_EXIST, HTTPCodes.NOT_FOUND, WebExceptionType.VALIDATION);
        }
    }
}
