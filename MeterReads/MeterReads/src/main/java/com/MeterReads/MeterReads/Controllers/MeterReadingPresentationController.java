package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.MeterReadingPresentation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MeterReadingPresentationController {

    @RequestMapping(value = "/meter-read", method = GET)
    public MeterReadingPresentation meterRead(@RequestParam(value = "customerId") String customerId, @RequestParam(value = "mpxn") String mpxn) {
        return new MeterReadingPresentation(customerId, mpxn);
    }

}
