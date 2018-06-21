package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.MeterReadsApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeterReadsApplication.class)
@WebAppConfiguration
public class MeterReadingPresentationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void meterRead_ValidRequestNoData_ExecutesReturnsNoData() {

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

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/meter-read/customerIds/{customerId}/serialNumbers/{serialNumber}", "1", "2"))
                .andDo(print()).andExpect(status().isOk());
    }

}