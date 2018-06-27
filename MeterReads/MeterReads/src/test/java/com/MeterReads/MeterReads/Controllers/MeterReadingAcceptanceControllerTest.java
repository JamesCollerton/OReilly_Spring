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
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeterReadsApplication.class)
@WebAppConfiguration
public class MeterReadingAcceptanceControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {

        String customerId = "customerId";
        long serialNumber = 1;
        long mpxn = 2;
        String readDate = "2017-11-20T16:19:48+00:00Z";

        String type = "type";
        long registerId = 3;
        long value = 4;

        MeterReading meterReading = new MeterReading();
        Read read = new Read();

        meterReading.setCustomerId(customerId);
        meterReading.setSerialNumber(serialNumber);
        meterReading.setMpxn(mpxn);
        meterReading.setReadDate("2017-11-20T16:19:48+00:00Z");

        read.setType(type);
        read.setRegisterId(registerId);
        read.setValue(value);

        meterReading.setRead(Collections.singletonList(read));

        mockMvc.perform(post("/meter-read")
                .contentType(contentType)
                .content(this.json(meterReading)))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerId", is(meterReading.getCustomerId())))
                .andExpect(jsonPath("$.serialNumber", is(new Long(meterReading.getSerialNumber()).intValue())))
                .andExpect(jsonPath("$.mpxn", is(new Long(meterReading.getMpxn()).intValue())))
                .andExpect(jsonPath("$.readDate", is(meterReading.getReadDate())))
                .andExpect(jsonPath("$.read", hasSize(1)))
                .andExpect(jsonPath("$.read[0].type", is(read.getType())))
                .andExpect(jsonPath("$.read[0].registerId", is(new Long(read.getRegisterId()).intValue())))
                .andExpect(jsonPath("$.read[0].value", is(new Long(read.getValue()).intValue())));

        List<MeterReading> meterReadingSaved = meterReadingRepository.findByCustomerIdAndSerialNumberAndMpxnAndReadDate(
                customerId,
                serialNumber,
                mpxn,
                readDate
        );

    }

    private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}