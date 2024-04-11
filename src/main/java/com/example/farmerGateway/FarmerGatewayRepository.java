package com.example.farmerGateway;




import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface FarmerRepository extends JpaRepository<Farmer, Long> {
    Optional<Farmer> findByUsername(String username);
}

