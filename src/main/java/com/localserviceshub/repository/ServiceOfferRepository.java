package com.localserviceshub.repository;

import com.localserviceshub.model.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOfferRepository extends JpaRepository<ServiceOffer, Long> {
    List<ServiceOffer> findByServiceTypeIgnoreCase(String serviceType);
}
