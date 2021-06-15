package io.easyware.platypus.api.domains;

import io.easyware.platypus.api.domains.objects.Domain;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository implements PanacheRepository<Domain> { }
