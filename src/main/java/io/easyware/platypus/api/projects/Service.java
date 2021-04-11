package io.easyware.platypus.api.projects;

import io.easyware.platypus.api.projects.objects.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@ApplicationScoped
public class Service {

    private final Repository repository;
    private final URI uri = UriBuilder.fromPath("/").build();

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Project> getProjectsOfAccount(String account) {
        return repository.listAll();
    }
}
