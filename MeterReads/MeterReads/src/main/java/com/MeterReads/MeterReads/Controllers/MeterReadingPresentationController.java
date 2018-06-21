package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import com.MeterReads.MeterReads.Utils.Parsing.StringParser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * This is the controller for displaying meter readings. It accepts two parameters, customerId and mpxn number in
 * order to uniquely identify a request.
 */
@RestController
public class MeterReadingPresentationController {

    @Autowired
    MeterReadingRepository meterReadingRepository;

    /**
     * This is the method for handling GET requests to the /meter-read URI.
     *
     * @param customerId The customerId given as part of the URI request
     * @param serialNumber The serialNumber number given as part of the URI request
     *
     * @return A new MeterReadingPresentation object containing the required reading.
     */
    @ApiOperation(
            httpMethod = "GET",
            value = "Get existing meter reading from the API",
            notes = "Meter reading will be returned as JSON",
            response = ResponseEntity.class
    )
    @RequestMapping(value = "/meter-read/customerIds/{customerId}/serialNumbers/{serialNumber}", method = GET)
    public ResponseEntity<List<MeterReading>> meterRead(@PathVariable String customerId, @PathVariable String serialNumber) {
        try {
            List<MeterReading> meterReadings = meterReadingRepository.findByCustomerIdAndSerialNumber(customerId, StringParser.parseLong(serialNumber));
            return new ResponseEntity<>(meterReadings, HttpStatus.OK);
        } catch (MeterReadsException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

}
