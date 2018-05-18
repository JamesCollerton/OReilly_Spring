package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Responses.MeterReadingPresentation;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * This is the method for handling GET requests to the /meter-read URI.
     *
     * @param customerId The customerId given as part of the URI request
     * @param mpxn The mpxn number given as part of the URI request
     *
     * @return A new MeterReadingPresentation object containing the required reading.
     */
    @ApiOperation(
            httpMethod = "GET",
            value = "Get existing meter reading from the API",
            notes = "Meter reading will be returned as JSON",
            response = MeterReadingPresentation.class
    )
    @RequestMapping(value = "/meter-read", method = GET)
    public ResponseEntity<List<MeterReading>> meterRead(@RequestParam(value = "customerId") String customerId, @RequestParam(value = "mpxn") String mpxn) {
        new MeterReadingPresentation(customerId, mpxn);
        List<MeterReading> list = Collections.singletonList(new MeterReading());
        return new ResponseEntity<List<MeterReading>>(list, HttpStatus.OK);
    }

}
