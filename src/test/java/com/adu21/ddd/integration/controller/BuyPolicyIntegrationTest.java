package com.adu21.ddd.integration.controller;

import com.adu21.ddd.controller.rest.PolicyController;
import com.adu21.ddd.integration.BaseIntegrationTest;
import com.adu21.ddd.model.HomePolicy;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.HomePolicyRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class BuyPolicyIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private PolicyController policyController;

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    private String inputJson;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(policyController).build();
    }

    @Test
    public void buyHomePolicySuccess() throws Exception{
        inputJson = "{\n" +
                "\t\"ownerEmail\": \"ownerEmail\",\n" +
                "\t\"ownerUserName\": \"ownerUserName\",\n" +
                "\t\"policyOwnerUuid\": \"policyOwnerUuid\",\n" +
                "\t\"startDate\": \"2019-11-11\",\n" +
                "\t\"buildingMaterial\": \"buildingMaterial\",\n" +
                "\t\"buildingType\": \"buildingType\",\n" +
                "\t\"numberOfRooms\": 4,\n" +
                "\t\"price\": 12.01,\n" +
                "\t\"quoteId\": \"quoteId\",\n" +
                "\t\"holderBirthday\": \"1999-12-12\",\n" +
                "\t\"holderEmail\": \"holderEmail\",\n" +
                "\t\"holderId\": \"holderId\"\n" +
                "}";
        mockMvc.perform(post("/api/homepolicy")
                .contentType(APPLICATION_JSON).content(inputJson))
                .andExpect(status().isCreated());
    }

}