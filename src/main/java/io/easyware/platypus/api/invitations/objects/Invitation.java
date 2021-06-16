package io.easyware.platypus.api.invitations.objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "invitations")
public class Invitation {

    public Invitation() { }

    @Id
    @Column(name = "id")
    private int id;

    @NotBlank
    @Size(max=36)
    @Column(name = "invitation_id")
    private String invitationId;

    @NotBlank
    @Size(max=36)
    @Column(name = "event")
    private String event;

    @NotBlank
    @Size(max=10)
    @Column(name = "event_id")
    private String eventId;

    @NotBlank
    @Size(max=20)
    private String name;

    @Column(name = "has_confirmed")
    private Boolean hasConfirmed;

    @Column(name = "updated_at")
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date updatedAt;

    @Size(max=100)
    @Column(name = "updated_by")
    private String updatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasConfirmed() {
        return hasConfirmed;
    }

    public void setHasConfirmed(Boolean hasConfirmed) {
        this.hasConfirmed = hasConfirmed;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
