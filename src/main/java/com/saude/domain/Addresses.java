package com.saude.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
@Data
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Column(name = "PRINCIPAL")
    private boolean principal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patients patient;

}
