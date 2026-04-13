package com.localserviceshub.repository;

import com.localserviceshub.model.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOfferRepository extends JpaRepository<ServiceOffer, Long> {
    List<ServiceOffer> findByServiceTypeIgnoreCase(String serviceType);
    List<ServiceOffer> findByStateIgnoreCase(String state);
    List<ServiceOffer> findByCityIgnoreCase(String city);
    List<ServiceOffer> findByStateIgnoreCaseAndCityIgnoreCase(String state, String city);
    List<ServiceOffer> findByServiceTypeIgnoreCaseAndStateIgnoreCase(String serviceType, String state);
    List<ServiceOffer> findByServiceTypeIgnoreCaseAndCityIgnoreCase(String serviceType, String city);
    List<ServiceOffer> findByServiceTypeIgnoreCaseAndStateIgnoreCaseAndCityIgnoreCase(String serviceType, String state, String city);
}
