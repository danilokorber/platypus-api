package io.easyware.platypus.api.projects;

import io.easyware.platypus.api.projects.objects.Project;
import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {

    private final Repository repository;
    private final URI uri = UriBuilder.fromPath("/").build();

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Project> getProjectsOfAccount(SecurityIdentity identity) {
        return repository.listAll().stream().filter(p -> identity.getRoles().contains(p.getDomainId())).collect(Collectors.toList());
    }
}
