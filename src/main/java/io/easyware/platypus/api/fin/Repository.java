package io.easyware.platypus.api.fin;

import io.easyware.platypus.api.fin.objects.CostCenter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository implements PanacheRepository<CostCenter> {
}
