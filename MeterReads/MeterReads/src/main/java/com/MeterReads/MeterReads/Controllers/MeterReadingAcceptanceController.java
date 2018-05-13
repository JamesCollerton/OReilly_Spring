package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.MeterReading;
import com.MeterReads.MeterReads.DataObjects.MeterReadingAcceptance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MeterReadingAcceptanceController {

    @RequestMapping(value = "/meter-read", method = POST)
    public MeterReadingAcceptance meterRead(@RequestBody MeterReading meterReading) {
        return new MeterReadingAcceptance(meterReading);
    }

}
