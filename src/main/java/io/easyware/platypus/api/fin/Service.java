package io.easyware.platypus.api.fin;

import io.easyware.platypus.api.fin.objects.CostCenter;
import io.easyware.platypus.api.fin.objects.Expense;
import io.easyware.platypus.api.fin.repositories.RepositoryCostCenter;
import io.easyware.platypus.api.fin.repositories.RepositoryExpense;
import io.easyware.platypus.api.keycloak.Permissions;
import io.easyware.platypus.exceptions.PlatypusPermissionsException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {
    private static final Logger LOGGER = Logger.getLogger( Service.class.getName() );

    private final RepositoryCostCenter repositoryCostCenter;
    private final RepositoryExpense repositoryExpense;
    private final URI uri = UriBuilder.fromPath("/").build();

    private Comparator<CostCenter> compareByName = (CostCenter cc1, CostCenter cc2) ->
            cc1.getName().compareTo( cc2.getName() );


    @Inject
    public Service(RepositoryCostCenter repositoryCostCenter, RepositoryExpense repositoryExpense) {
        this.repositoryCostCenter = repositoryCostCenter;
        this.repositoryExpense = repositoryExpense;
         }

    @Inject
    Permissions permissions;

    public List<CostCenter> getParentCostCenters(int domainId) throws PlatypusPermissionsException {
        if (permissions.hasPermissionInDomain(domainId)) {
            return repositoryCostCenter.listAll().stream().filter(c -> c.getDomainId() == domainId && c.getParentId() == 0).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public CostCenter getCostCenter(int id) throws PlatypusPermissionsException {
        CostCenter cc = repositoryCostCenter.listAll().stream().filter(c -> c.getId() == id).findFirst().get();
        if (permissions.hasPermissionInDomain(cc.getDomainId())) {
            return cc;
        } else {
            return null;
        }
    }

    public List<CostCenter> getCostCenters(int domainId) throws PlatypusPermissionsException {
        return getCostCenters(domainId, 0);
    }

    public List<CostCenter> getCostCenters(int domainId, int parentId) throws PlatypusPermissionsException  {
        if (permissions.hasPermissionInDomain(domainId)) {
            List<CostCenter> listOfCostCenters = repositoryCostCenter.listAll().stream().filter(c -> c.getDomainId() == domainId && c.getParentId() == parentId).collect(Collectors.toList());
            listOfCostCenters.forEach(costCenter -> {
                try {
                    costCenter.setChildren(getCostCenters(domainId, costCenter.getId()));
                } catch (PlatypusPermissionsException e) {}
            });
            Collections.sort(listOfCostCenters, this.compareByName);
            return listOfCostCenters;
        } else {
            return null;
        }
    }

    @Transactional
    public CostCenter addCostCenter(CostCenter costCenter) throws PlatypusPermissionsException {
        if (permissions.hasPermissionInDomain(costCenter.getDomainId())) {
            repositoryCostCenter.persistAndFlush(costCenter);
            return repositoryCostCenter.find("domainId = ?1 and name = ?2", costCenter.getDomainId(), costCenter.getName()).firstResult();
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteCostCenter(int id) throws PlatypusPermissionsException {
        CostCenter cc = getCostCenter(id);
        if (permissions.hasPermissionInDomain(cc.getDomainId())) {
            repositoryCostCenter.delete("id = ?1", id);
        }
    }

    public List<Expense> getExpenses(int domainId) throws PlatypusPermissionsException {
        if (permissions.hasPermissionInDomain(domainId)) {
            return repositoryExpense.listAll().stream().filter(c -> c.getDomainId() == domainId).collect(Collectors.toList());
        } else {
            return null;
        }
    }

}
