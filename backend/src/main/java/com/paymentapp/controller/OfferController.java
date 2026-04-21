package com.paymentapp.controller;

import com.paymentapp.model.Offer;
import com.paymentapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = "*")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getOffers() {
        return offerService.getPersonalisedOffers();
    }
}
