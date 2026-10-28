package com.favagostar.requestapproval.models;

import com.favagostar.requestapproval.models.Enums.RequestStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_PURCHASE_REQUEST")
@SequenceGenerator(name = "SEQ_PURCHASE_REQUEST",sequenceName = "SEQ_PURCHASE_REQUEST",allocationSize = 1)
@Audited
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PURCHASE_REQUEST")
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE", nullable = false, length = 200)
    @NotBlank
    @Size(max = 200)
    private String title;
    @Column(name = "DESCRIPTION",length = 2000)
    @Size(max = 2000)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "REQUESTER_ID",nullable = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Employee requester;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPROVER_ID")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Employee approver;
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;
    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @Column(name = "VERSION")
    @Version
    private Long version;


}
