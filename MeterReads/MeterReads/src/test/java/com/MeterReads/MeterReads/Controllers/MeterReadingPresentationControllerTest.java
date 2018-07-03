package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;
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
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
        mockMvc.perform(get(MeterReadingPresentationController.URI)
                    .param("customerId", "customerId")
                    .param("serialNumber", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void meterRead_ValidRequestData_ExecutesReturnsCorrectData() throws Exception {

        String customerId = "customerId";
        long serialNumber = 1;
        long registerId = 1;

        MeterReading meterReading = new MeterReading();
        Read read = new Read();

        read.setRegisterId(registerId);

        meterReading.setCustomerId(customerId);
        meterReading.setSerialNumber(serialNumber);
        meterReading.setRead(Collections.singletonList(read));

        MeterReading savedMeterReading = meterReadingRepository.save(meterReading);

        mockMvc.perform(get(MeterReadingPresentationController.URI)
                    .param("customerId", customerId)
                    .param("serialNumber", Long.toString(serialNumber))
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].customerId", is(savedMeterReading.getCustomerId())))
                .andExpect(jsonPath("$[0].serialNumber", is(new Long(savedMeterReading.getSerialNumber()).intValue())))
                .andExpect(jsonPath("$[0].read", hasSize(1)))
                .andExpect(jsonPath("$[0].read[0].registerId", is(new Long(savedMeterReading.getRead().get(0).getRegisterId()).intValue())));

    }

}