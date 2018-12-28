package com.example.DemoGraphQL.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ORGANIZATION")
public class Organization {

  @Id
  @Column(name = "PARTY_ID")
  private Long id;

  @Column(name = "FULL_NAME")
  private String fullName;

  @Column(name = "SHORT_NAME")
  private String shortName;

  @Column(name = "INN")
  private String inn;

  @Column(name = "OGRN")
  private String ogrn;

  @Column(name = "OGRN_ASSIGN_DATE")
  private Date ogrnAssignDate;

  @Column(name = "OGRN_AUTHORITY")
  private String ogrnAuthority;

  @Column(name = "CODE_OKPO")
  private String codeOkpo;

  @Column(name = "MAIN_ACTIVITY_CODE")
  private String okved;

  @Column(name = "KPP")
  private String kpp;

  @Column(name = "SPR_OPF_CODE")
  private String okopf;

  @Column(name = "REG_OKTMO")
  private String oktmo;

  @Column(name = "REG_OKATO")
  private String okato;

  @Column(name = "IS_AUTHORITY")
  private String isAuthority;

  @Column(name = "IS_PUBLIC_OWNERSHIP")
  private String isPublicOwnership;

  @Column(name = "PUBLIC_OWNERSHIP_TYPE")
  private String publicOwnershipType;

  @Column(name = "IS_PUBLIC_PAYER")
  private String isPublicPayer;

  @Column(name = "REG_CAPITAL_TYPE")
  private String regCapitalType;

  @Column(name = "REG_CAPITAL_RUB")
  private String regCapitalRub;

  @Column(name = "MAIN_ACTIVITY_CV")
  private String mainActivityCv;

  @Column(name = "MAIN_ACTIVITY_DESC")
  private String mainActivityDesc;

  @Column(name = "LEGAL_CAPACITY")
  private String legalCapacity;

  @Column(name = "INCAP_STATUS_CODE")
  private String incapStatusCode;

  @Column(name = "INCAP_STATUS_DESC")
  private String incapStatusDesc;

  @Column(name = "INCAP_DATE")
  private Date incapDate;

  @Column(name = "EXCL_DEC_DATE")
  private Date exclDecDate;

  @Column(name = "EXCL_DEC_NUM")
  private String exclDecNum;

  @Column(name = "EXCL_PUB_DATE")
  private Date exclPubDate;

  @Column(name = "EXCL_PUB_MAG")
  private String exclPubMag;

  @Column(name = "IS_TERMINATED")
  private String isTerminated;

  @Column(name = "TERM_CASE_CODE")
  private String termCaseCode;

  @Column(name = "TERM_CASE_DESC")
  private String termCaseDesc;

  @Column(name = "TERMINATION_DATE")
  private Date terminationDate;

  @Column(name = "SUCCESSOR_ID")
  private String successorId;

  @Column(name = "DATE_FROM")
  private Date dateFrom;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PARTY_ID")
  @NotFound(action= NotFoundAction.IGNORE)
  private ManagingFirm managingFirm;

  @Formula("(select 'test addr' from dual)")
  private String registrationAddress;

  @Formula("(select 'test addr' from dual)")
  private String factAddress;

  @OneToMany(mappedBy = "accountOwner", fetch = FetchType.LAZY)
  @Fetch(FetchMode.JOIN)
  @NotFound(action= NotFoundAction.IGNORE)
  private Set<SettlementAccount> settlementAccounts;

  @OneToMany(mappedBy = "accountOwner", fetch = FetchType.LAZY)
  @Fetch(FetchMode.JOIN)
  @NotFound(action= NotFoundAction.IGNORE)
  private Set<BusinessAccount> businessAccounts;

  public Organization() {
  }
}
