package com.example.DemoGraphQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "BUSINESS_ACCOUNT")
public class BusinessAccount {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_OWNER")
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Organization accountOwner;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "SETTLEMENT_ACOUNT")
    private String settlementAccount;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "DATE_FROM")
    private LocalDate dateFrom;

    @Column(name = "DATE_TO")
    private LocalDate dateTo;

}
