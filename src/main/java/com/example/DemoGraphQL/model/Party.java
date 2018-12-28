package com.example.DemoGraphQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name = "PARTY")
@SequenceGenerator(name = "seq", sequenceName = "PARTY_ID_SEQ")
public class Party {

    @Id
    @Column(name = "PARTY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long partyId;

    @Column(name = "PARTY_TYPE_ID")
    private String partyTypeId;

    @Column(name = "PRIMARY_ID")
    private String primaryId;

    @Override
    public String toString() {
        return "Party{" + "partyId=" + partyId + ", partyTypeId='" + partyTypeId + '\'' + ", primaryId='" + primaryId + '\'' + '}';
    }
}
