package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.MeterReading;
import com.MeterReads.MeterReads.DataObjects.MeterReadingAcceptance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * This is the controller for accepting new meter readings. It can be accessed via a POST request to the /meter-read
 * URI. It parses the body as JSON directly into a MeterReading object and returns a new MeterReadingAcceptance object
 * which will indicate the success of the request.
 */
@RestController
public class MeterReadingAcceptanceController {

    /**
     * This method contains the mapping for the POST to meter-read. It parses the request body as a JSON of the
     * incoming meter reading and passes it to a new MeterReadingAcceptance object to ingest and return a success
     * code.
     *
     * @param meterReading The JSON of the body of the POST request
     *
     * @return A MeterReadingAcceptance object indicating if ingestion was successful
     */
    @RequestMapping(value = "/meter-read", method = POST)
    public MeterReadingAcceptance meterRead(@RequestBody MeterReading meterReading) {
        return new MeterReadingAcceptance(meterReading);
    }

}
