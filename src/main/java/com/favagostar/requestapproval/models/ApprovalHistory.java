package com.favagostar.requestapproval.models;

import com.favagostar.requestapproval.models.Enums.ApprovalAction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "TBL_APPROVAL_HISTORY")
@Entity
@SequenceGenerator(name = "SQ_ApprovalHistory", sequenceName = "SQ_ApprovalHistory", allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class ApprovalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ApprovalHistory")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "PURCHASE_REQUEST_ID")
    @NotNull
    private PurchaseRequest purchaseRequest;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ACTOR_ID")
    @NotNull
    private Employee actor;
    @Column(name = "COMMENT", length = 500)
    @Size(max = 500)
    private String comment;
    @NotNull
    @Column(name = "ACTION" , nullable = false)
    @Enumerated(EnumType.STRING)
    private ApprovalAction action;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    public ApprovalHistory(PurchaseRequest purchaseRequest,Employee actor, ApprovalAction action){
        this.purchaseRequest=purchaseRequest;
        this.actor=actor;
        this.action=action;
    }



}
