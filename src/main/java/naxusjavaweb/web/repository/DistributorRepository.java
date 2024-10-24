package naxusjavaweb.web.repository;

import naxusjavaweb.web.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    // Custom query methods can be added here if needed
}