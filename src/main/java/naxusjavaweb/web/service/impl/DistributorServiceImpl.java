package naxusjavaweb.web.service.impl;

import naxusjavaweb.web.entity.Distributor;
import naxusjavaweb.web.repository.DistributorRepository;
import naxusjavaweb.web.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorServiceImpl implements DistributorService {

    private final DistributorRepository distributorRepository;

    @Autowired
    public DistributorServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    @Override
    public Optional<Distributor> getDistributorById(Long id) {
        return distributorRepository.findById(id);
    }

    @Override
    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    @Override
    public void deleteDistributor(Long id) {
        distributorRepository.deleteById(id);
    }
}