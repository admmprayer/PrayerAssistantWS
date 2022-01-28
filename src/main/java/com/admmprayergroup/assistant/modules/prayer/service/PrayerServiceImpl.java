package com.admmprayergroup.assistant.modules.prayer.service;

import com.admmprayergroup.assistant.dto.EntityType;
import com.admmprayergroup.assistant.dto.PrayerResponse;
import com.admmprayergroup.assistant.dto.models.PrayerSlot;
import com.admmprayergroup.assistant.vo.AppUtils;
import com.admmprayergroup.assistant.vo.FirestoreDocument;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrayerServiceImpl implements PrayerService {

    @Autowired
    private FirestoreDocument firestoreDoc;

    @Autowired
    private AppUtils appUtils;


    @Override
    public List<PrayerResponse> getCompletedPrayerSlots(String id, EntityType entityType) throws Exception {
        String celebrateID = this.updateIDWithEntityType(id, entityType);

        Query completedPrayerSlotsQuery = firestoreDoc.getDB()
                .collection(FirestoreDocument.COLLECTION_PRAYER_SLOT)
                .whereEqualTo(FirestoreDocument.DOC_CELEBRATE_ID, celebrateID)
                .whereLessThan(FirestoreDocument.DOC_DATE, Timestamp.now())
                .orderBy(FirestoreDocument.DOC_DATE);
        List<QueryDocumentSnapshot> completedPrayerSlotsSnapShot = completedPrayerSlotsQuery.get().get().getDocuments();

        return this.convertPrayerModelToResponse(completedPrayerSlotsSnapShot);
    }

    @Override
    public List<PrayerResponse> getDuePrayerSlots(String id, EntityType entityType) throws Exception {
        String celebrateID = this.updateIDWithEntityType(id, entityType);

        Query completedPrayerSlotsQuery = firestoreDoc.getDB()
                .collection(FirestoreDocument.COLLECTION_PRAYER_SLOT)
                .whereEqualTo(FirestoreDocument.DOC_CELEBRATE_ID, celebrateID)
                .whereGreaterThan(FirestoreDocument.DOC_DATE, Timestamp.now())
                .orderBy(FirestoreDocument.DOC_DATE);
        List<QueryDocumentSnapshot> completedPrayerSlotsSnapShot = completedPrayerSlotsQuery.get().get().getDocuments();

        return this.convertPrayerModelToResponse(completedPrayerSlotsSnapShot);
    }

    @Override
    public void savePrayerSlotInformation(PrayerSlot prayerSlot) throws Exception {
        firestoreDoc.save(FirestoreDocument.COLLECTION_PRAYER_SLOT, prayerSlot.getPrayerSlotID(), prayerSlot);
    }

    @Override
    public void updatePrayerSlotInformation(PrayerSlot prayerSlot) throws Exception {
        firestoreDoc.update(FirestoreDocument.COLLECTION_PRAYER_SLOT, prayerSlot.getPrayerSlotID(), prayerSlot);
    }

    private List<PrayerResponse> convertPrayerModelToResponse(List<QueryDocumentSnapshot> queryDocumentSnapshotList) {
        return queryDocumentSnapshotList.stream()
                .map(documentSnapshot -> appUtils.transferValues(
                        documentSnapshot.toObject(PrayerSlot.class),
                        PrayerSlot.class,
                        PrayerResponse.class))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private String updateIDWithEntityType(String id, EntityType entityType) throws Exception {
        switch (entityType) {
            case PARISH:
                return "P".concat(id);
            case VICARIATE:
                return "V".concat(id);
            case GROUP:
                return "G".concat(id);
            default:
                throw new Exception("invalid Entity type");
        }
    }
}
