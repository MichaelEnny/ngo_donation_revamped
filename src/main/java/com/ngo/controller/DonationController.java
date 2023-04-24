package com.ngo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.Donation;
import com.ngo.service.DonationService;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class DonationController {

    public static final Logger logger = LoggerFactory.getLogger(DonationController.class);
    @Autowired
    DonationService service;

    // to get list of product objects to the consumer
    // get
    @GetMapping("/donations")
    public List<Donation> getList()
    {
        logger.info("Entering into method getList()");
        try {
            logger.info("finding all Donation contents");
            throw new RuntimeException("Donation information list not available");
        } catch (Exception e) {
            logger.error(" Unable to find donation contents list " +e.getMessage());
            e.printStackTrace();
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Exception is -: " +sw.toString());
        }
        return service.getAllDonations();
    }

    @GetMapping("/donations/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Donation> get(@PathVariable Long id)
    {
        logger.info("Entering into method get()");
        try {
            logger.info("finding all donation contents by id");
            throw new RuntimeException("Donation information by id not available");
        } catch (Exception e) {
            logger.error(" Unable to find donation contents by id " +e.getMessage());
            e.printStackTrace();
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Exception is -: " +sw.toString());
        }
        try
        {
            Optional<Donation> donation = service.getDonationById(id);
            return new ResponseEntity<Donation>(HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            // TODO: handle exception
            return new ResponseEntity<Donation>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/donations")
    @PreAuthorize("hasRole('USER')")
    public void add(@RequestBody Donation donation)
    {
        logger.info("Entering into method add()");
        try {
            logger.info("Adding donation contents to the server");
            throw new RuntimeException("Donation information not adding to donation server");
        } catch (Exception e) {
            logger.error(" Unable to add talk contents " +e.getMessage());
            e.printStackTrace();
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Exception is -: " +sw.toString());
        }
        service.createDonation(donation);
    }

    @DeleteMapping("/donations/{id}")
    public void delete(@PathVariable Long id)
    {
        logger.info("Entering into method delete()");
        try {
            logger.info("Deleting donation contents from the server");
            throw new RuntimeException("Donation information not deleting from donation server");
        } catch (Exception e) {
            logger.error(" Unable to delete donation contents " +e.getMessage());
            e.printStackTrace();
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Exception is -: " +sw.toString());
        }
        service.deleteDonation(id);
    }

    @PutMapping("/donations/{id}")
    public void update(@RequestBody Donation donation, @PathVariable Long id)
    {
        logger.info("Entering into method update()");
        try {
            logger.info("Updating donation contents from the server");
            throw new RuntimeException("Donation information not updating in donation server");
        } catch (Exception e) {
            logger.error(" Unable to update donation contents " +e.getMessage());
            e.printStackTrace();
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Exception is -: " +sw.toString());
        }

        donation.setId(id);

        service.updateDonation(donation);
    }

}

