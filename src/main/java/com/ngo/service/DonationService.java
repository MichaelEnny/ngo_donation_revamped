package com.ngo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Donation;
import com.ngo.repositories.DonationRepository;

/**
 * Created by Michael Eniolade
 */

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation createDonation(Donation donation){
        return donationRepository.save(donation);
    }

    public List<Donation> getAllDonations(){
        return (List<Donation>) donationRepository.findAll();
    }

    public Optional<Donation> getDonationById(long id){
        return donationRepository.findById(id);
    }

    public Donation updateDonation(Donation donation){
        return donationRepository.save(donation);
    }

    public void deleteDonation(long id){
        donationRepository.deleteById(id);
    }

}


