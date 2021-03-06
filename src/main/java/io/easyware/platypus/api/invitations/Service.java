package io.easyware.platypus.api.invitations;

import io.easyware.platypus.api.invitations.objects.Invitation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {
    private static final Logger LOGGER = Logger.getLogger( Api.class.getName() );

    private final Repository repository;
    private final URI uri = UriBuilder.fromPath("/").build();

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public Invitation getInvitation(String invitationId) {
        return repository.find("invitation_id", invitationId).firstResult();
    }

    @Transactional
    public void scan(String invitationId) {
        Invitation invitation = getInvitation(invitationId);
        invitation.setScans(invitation.getScans() + 1);
        //return invitation;
    }

    @Transactional
    public Invitation postConfirmation(String invitationId, Boolean confirm) {
        Invitation invitation = getInvitation(invitationId);
        invitation.setHasConfirmed(confirm);
        invitation.setUpdatedAt(new Date());
        return invitation;
    }

    public List<Invitation> getInvitationsFrom(String eventId) {
        return repository.listAll().stream().filter(i -> i.getEventId().equals(eventId)).collect(Collectors.toList());
    }
}
