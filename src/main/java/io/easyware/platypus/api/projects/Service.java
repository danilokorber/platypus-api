package io.easyware.platypus.api.projects;

import io.easyware.platypus.api.projects.objects.Project;

import java.util.ArrayList;

public interface Service {

    ArrayList<Project> getProjectsOfAccount(String account);
}
