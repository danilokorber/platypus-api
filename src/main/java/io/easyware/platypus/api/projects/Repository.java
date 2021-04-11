package io.easyware.platypus.api.projects;

import io.easyware.platypus.api.projects.objects.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository implements PanacheRepository<Project> { }
