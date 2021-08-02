package io.easyware.platypus.api.keycloak;

import io.easyware.platypus.api.domains.Service;
import io.easyware.platypus.api.domains.objects.Domain;
import io.easyware.platypus.exceptions.PlatypusPermissionsException;
import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Permissions {

    @Inject
    Service domainService;

    @Inject
    SecurityIdentity identity;

    public boolean hasPermissionInDomain(int domainId) throws PlatypusPermissionsException {
        Domain domain = domainService.getByID(domainId);
        String domainUUID = domain.getUid();
        if (identity.getRoles().contains(domainUUID)) {
            return true;
        } else {
            throw new PlatypusPermissionsException(identity.getPrincipal().getName() + " don\'t have permissions in domain_id " + domain.getId() + ".");
        }
    }
}
