package com.example.DemoGraphQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "MANAGING_FIRM")
public class ManagingFirm {

    @Id
    @Column(name = "PARTY_ID")
    private Long partyId;

    @Column(name = "MF_CODE")
    private String kbk;

    @Column(name = "GISRD_ID")
    private String gisrdId;

    @Column(name = "MF_TYPE_ID")
    private String mfTypeId;

    @Column(name = "IS_ACTIVE")
    private String isActive;

    @Column(name = "LIC_NUM")
    private String licNum;

    @Column(name = "ISSUANCE_DATE")
    private Date issuanceDate;

    @Column(name = "ISSUED_BY")
    private String issuedBy;

    @Column(name = "LIC_STATE")
    private String licState;

    @Column(name = "HOUSE_CNT")
    private String houseCnt;

    @Column(name = "SA_IND_ID")
    private String saIndId;

    @Column(name = "SA_ORG_ID")
    private String saOrgId;

    @Column(name = "BA_IND_ID")
    private String baIndId;

    @Column(name = "BA_ORG_ID")
    private String baOrgId;

    @Column(name = "BCC_PRINCIPAL")
    private String bccPrincipal;

    @Column(name = "BCC_PENI")
    private String bccPeni;

    @Column(name = "BCC_DUTY")
    private String bccDuty;

    @Column(name = "DATE_FROM")
    private Date dateFrom;

}
