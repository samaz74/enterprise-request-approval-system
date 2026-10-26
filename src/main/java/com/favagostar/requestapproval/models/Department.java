package com.favagostar.requestapproval.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq_gen")
    @SequenceGenerator(name = "department_seq_gen" , sequenceName = "SEQ_DEPARTMENT", allocationSize = 1)
    private Long Id;
    @NotNull
    @Size(max = 100)
    @Column(name = "Name", nullable = false,length = 100)
    private String name;
    @NotBlank
    @Column(name = "CODE",unique = true, length = 30)
    @Size(max = 30)
    private String code;
    @Column(name = "ACTIVE",nullable = false)
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private boolean active;
}
