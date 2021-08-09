package io.easyware.platypus.api.fin.repositories;

import io.easyware.platypus.api.fin.objects.ExpenseGroup;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositoryExpenseGroup implements PanacheRepository<ExpenseGroup> {
}
