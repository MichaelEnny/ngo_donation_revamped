package com.ngo.repositories;

import com.ngo.model.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonationType(String donationType);

    Optional<Donation> findById(Long pollId);

    Page<Donation> findByCreatedBy(Long userId, Pageable pageable);

    long countByCreatedBy(Long userId);

    List<Donation> findByIdIn(List<Long> donationIds);

    List<Donation> findByIdIn(List<Long> donationIds, Sort sort);
}
