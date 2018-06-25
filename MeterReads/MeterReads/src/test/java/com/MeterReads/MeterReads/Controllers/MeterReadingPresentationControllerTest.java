package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.MeterReadsApplication;
import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeterReadsApplication.class)
@WebAppConfiguration
public class MeterReadingPresentationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.meterReadingRepository.deleteAll();
    }

    @Test
    public void meterRead_ValidRequestNoData_ExecutesReturnsNoData() throws Exception {
        mockMvc.perform(get("/meter-read/customerIds/{customerId}/serialNumbers/{serialNumber}", "customerId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void meterRead_ValidRequestData_ExecutesReturnsCorrectData() {

    }

    @Test
    public void meterRead_ValidRequestDataNoReads_ExecutesReturnsCorrectData() {

    }

    @Test
    public void meterRead_InvalidRequestNoCustomerId_ExecutesReturnsErrorCode() {

    }

    @Test
    public void meterRead_InvalidRequestNoSerialNumber_ExecutesReturnsErrorCode() {

    }

    @Test
    public void meterRead_InvalidRequestInvalidURI_ExecutesReturnsErrorCode() {

    }

}