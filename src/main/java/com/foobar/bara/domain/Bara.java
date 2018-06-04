package com.foobar.bara.domain;

import javax.persistence.*;

@Entity
@Table(name = "bar")
public class Bara {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bar_id_seq")
    //@SequenceGenerator(name = "bar_id_seq", sequenceName = "bar_id_seq", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BAR")
    private String bar;

    Bara(String bar) {
        this.bar = bar;
    }

    Bara() {
        // Default constructor needed by JPA
    }

    public String getBara() {
        return bar;
    }
}
