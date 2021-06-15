package io.easyware.platypus.api.invitations;

import io.easyware.platypus.api.invitations.objects.Invitation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository implements PanacheRepository<Invitation> {
}
