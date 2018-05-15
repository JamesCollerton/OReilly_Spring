package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.MeterReadingPresentation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public MeterReadingPresentation meterRead(@RequestParam(value = "customerId") String customerId, @RequestParam(value = "mpxn") String mpxn) {
        return new MeterReadingPresentation(customerId, mpxn);
    }

}
