package com.example.DemoGraphQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "SETTLEMENT_ACCOUNT")
public class SettlementAccount {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "ACCOUNT_OWNER")
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Organization accountOwner;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "ACCOUNT_BANK")
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Organization accountBank;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "CA_BANK")
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Organization caBank;

    @Column(name = "CA_NUMBER")
    private String caNumber;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "DATE_FROM")
    private Date dateFrom;

    @Column(name = "DATE_TO")
    private Date dateTo;

}
