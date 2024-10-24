package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Distributor;
import java.util.List;
import java.util.Optional;

public interface DistributorService {
    List<Distributor> getAllDistributors();

    Optional<Distributor> getDistributorById(Long id);

    Distributor saveDistributor(Distributor distributor);

    void deleteDistributor(Long id);
}