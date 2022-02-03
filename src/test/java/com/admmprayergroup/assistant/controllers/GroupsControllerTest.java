package com.admmprayergroup.assistant.controllers;

import com.admmprayergroup.assistant.modules.group.ArchdiocesanGroup;
import com.admmprayergroup.assistant.modules.group.service.GroupInfoService;
import com.admmprayergroup.assistant.modules.parish.dto.PrayerInfoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.times;

@WebMvcTest(GroupsController.class)
public class GroupsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GroupInfoService groupInfoService;

    @Test
    void getOneGroupInfo_Success_Returns200() throws Exception {
        PrayerInfoResponse subParishResponse = new PrayerInfoResponse();
        subParishResponse.setGroupInfo(new ArchdiocesanGroup());
        subParishResponse.setPrayerSlotsCompleted(Collections.emptyList());
        subParishResponse.setPrayerSlotsDue(Collections.emptyList());

        Mockito.when(groupInfoService.getOneGroup(Mockito.anyLong())).thenReturn(subParishResponse);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/group/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        MockMvcResultMatchers.jsonPath("$.groupInfo", Matchers.is(Matchers.notNullValue(ArchdiocesanGroup.class))),
                        MockMvcResultMatchers.jsonPath("$.prayerSlotsCompleted", Matchers.is(Collections.emptyList())),
                        MockMvcResultMatchers.jsonPath("$.prayerSlotsDue", Matchers.is(Collections.emptyList()))
                );
        Mockito.verify(groupInfoService, times(1)).getOneGroup(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(groupInfoService);
    }

    @Test
    void saveOrUpdateGroupInfo_Success_Returns200() throws Exception {
        // SAVE
        ArchdiocesanGroup group = this.getGroupSampleInstance();

        Mockito.when(groupInfoService.saveGroupDetails(Mockito.any(ArchdiocesanGroup.class))).thenReturn(group);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/group")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(group))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.groupNameEnglish", Matchers.is("St. Mary's Archdiocesan Prayer Group")),
                        MockMvcResultMatchers.jsonPath("$.groupNameTamil", Matchers.is("அன்னை மரியாள் உயர்மறைமாவட்ட செபக்குழு")),
                        MockMvcResultMatchers.jsonPath("$.groupHeadName", Matchers.nullValue()),
                        MockMvcResultMatchers.jsonPath("$.groupHeadPhoneNumber", Matchers.nullValue()),
                        MockMvcResultMatchers.jsonPath("$.contactPerson1Name", Matchers.nullValue()),
                        MockMvcResultMatchers.jsonPath("$.contactPerson1PhoneNumber", Matchers.nullValue()),
                        MockMvcResultMatchers.jsonPath("$.contactPerson2Name", Matchers.nullValue()),
                        MockMvcResultMatchers.jsonPath("$.contactPerson2PhoneNumber", Matchers.nullValue())
                );
        Mockito.verify(groupInfoService, times(1)).saveGroupDetails(Mockito.any(ArchdiocesanGroup.class));
        Mockito.verifyNoMoreInteractions(groupInfoService);
    }

    @Test
    void deleteOneGroupInfo_Success_Returns200() throws Exception {
        ArchdiocesanGroup group = this.getGroupSampleInstance();

        Mockito.doNothing().when(groupInfoService).deleteGroupDetails(Mockito.anyLong());
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/group")
                        .header("group-id", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(group))
                )
                .andExpect(MockMvcResultMatchers.status().isAccepted());
        Mockito.verify(groupInfoService, times(1)).deleteGroupDetails(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(groupInfoService);
    }

    private ArchdiocesanGroup getGroupSampleInstance() {
        ArchdiocesanGroup group = new ArchdiocesanGroup();
        group.setId(1L);
        group.setGroupNameEnglish("St. Mary's Archdiocesan Prayer Group");
        group.setGroupNameTamil("அன்னை மரியாள் உயர்மறைமாவட்ட செபக்குழு");
        return group;
    }

}
