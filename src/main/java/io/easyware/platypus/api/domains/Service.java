package io.easyware.platypus.api.domains;

import io.easyware.platypus.api.domains.objects.Domain;
import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {

    private final Repository repository;
    private final URI uri = UriBuilder.fromPath("/").build();

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Domain> getDomainsFromAccount(SecurityIdentity identity) {
        return repository.listAll().stream().filter(domain -> identity.getRoles().contains(domain.getUid())).collect(Collectors.toList());
    }

}
