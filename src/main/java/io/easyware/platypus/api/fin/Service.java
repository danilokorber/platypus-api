package io.easyware.platypus.api.fin;

import io.easyware.platypus.api.fin.objects.CostCenter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {
    private static final Logger LOGGER = Logger.getLogger( Service.class.getName() );

    private final Repository repository;
    private final URI uri = UriBuilder.fromPath("/").build();

    private Comparator<CostCenter> compareByName = (CostCenter cc1, CostCenter cc2) ->
            cc1.getName().compareTo( cc2.getName() );

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<CostCenter> getParentCostCenters(int domainId) {
        return repository.listAll().stream().filter(c -> c.getDomainId() == domainId && c.getParentId() == 0).collect(Collectors.toList());
    }

    public CostCenter getCostCenter(int id) { return repository.listAll().stream().filter(c -> c.getId() == id).findFirst().get(); }

    public List<CostCenter> getCostCenters(int domainId) {
        return getCostCenters(domainId, 0);
    }

    public List<CostCenter> getCostCenters(int domainId, int parentId) {
        LOGGER.log(Level.INFO, "domainId: " + domainId + " parentId: " + parentId);
        List<CostCenter> listOfCostCenters = repository.listAll().stream().filter(c -> c.getDomainId() == domainId && c.getParentId() == parentId).collect(Collectors.toList());
        listOfCostCenters.forEach(costCenter -> costCenter.setChildren(getCostCenters(domainId, costCenter.getId())) );
        Collections.sort(listOfCostCenters, this.compareByName);
        return listOfCostCenters;
    }

    @Transactional
    public CostCenter addCostCenter(CostCenter costCenter) {
        repository.persistAndFlush(costCenter);
        return repository.find("domainId = ?1 and name = ?2", costCenter.getDomainId(), costCenter.getName()).firstResult();
    }

    @Transactional
    public void deleteCostCenter(int id) {
        repository.delete("id = ?1", id);
    }
}
