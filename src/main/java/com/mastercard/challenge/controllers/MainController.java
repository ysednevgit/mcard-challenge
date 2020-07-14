package com.mastercard.challenge.controllers;

import com.mastercard.challenge.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ysedn on Jul 13, 2020
 */
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/connected")
    public boolean areCitiesConnected(@RequestParam(required = false) String origin,
                                      @RequestParam(required = false) String destination) {

        return mainService.areCitiesConnected(origin, destination);
    }

}
