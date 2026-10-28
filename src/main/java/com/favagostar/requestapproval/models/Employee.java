package com.favagostar.requestapproval.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE",allocationSize = 1)
@Table(name = "TBL_EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @Column(name = "ID")
    private Long id;
    @Column(name = "FULL_NAME", length = 150,nullable = false)
    @Size(max = 150)
    @NotBlank
    private String fullName;
    @Column(name = "EMAIL", unique = true,length = 150,nullable = false)
    @Email
    @Size(max = 150)
    @NotBlank
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false,foreignKey =@ForeignKey(name = "FK_DEPARTMAENT_ID"))
    private Department department;
    @Column(name = "ACTIVE" , nullable = false)
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private boolean active = true;

    public Employee(String fullName, String email, Department department){
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }

}
