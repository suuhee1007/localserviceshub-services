package com.localserviceshub.controller;

import com.localserviceshub.dto.ServiceOfferRequest;
import com.localserviceshub.model.ServiceOffer;
import com.localserviceshub.repository.ServiceOfferRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = {"http://localhost:3000","https://localserviceshub-portal.vercel.app", "https://localserviceshub-2gk0mrrpr-suuhee1007s-projects.vercel.app"})
public class ServiceOfferController {

    private final ServiceOfferRepository repository;

    public ServiceOfferController(ServiceOfferRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ServiceOffer> createService(@Valid @RequestBody ServiceOfferRequest request) {
        ServiceOffer offer = new ServiceOffer();
        offer.setServiceName(request.getServiceName());
        offer.setServiceDescription(request.getServiceDescription());
        offer.setServiceType(request.getServiceType());
        offer.setCity(request.getCity());
        offer.setZipCode(request.getZipCode());
        offer.setAddress(request.getAddress());
        offer.setCreatedAt(Instant.now());
        ServiceOffer saved = repository.save(offer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<ServiceOffer> listServices(@RequestParam(value = "type", required = false) String type) {
        if (type == null || type.isBlank()) {
            return repository.findAll();
        }
        return repository.findByServiceTypeIgnoreCase(type);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffer> getServiceById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
