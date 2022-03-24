package com.trader.oneCrore.entity;


import java.sql.Timestamp;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "CHILD")
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "SYMBOL")
    private String Symbol;

    @Column(name = "SASIBUY")
    private String sasiBuy;

    @Column(name = "GOLDENBUY")
    private String goldenBuy;

    @Column(name = "SUPERBUY")
    private String superBuy;

    @Column(name = "CREATIONDATE")
    private Timestamp creationDate;

    @Column(name = "PERCENTAGE")
    private String percentage;

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public String getSymbol() {
        return Symbol;
    }


    public String getSasiBuy() {
        return sasiBuy;
    }

    public void setSasiBuy(String sasiBuy) {
        this.sasiBuy = sasiBuy;
    }

    public String getGoldenBuy() {
        return goldenBuy;
    }

    public void setGoldenBuy(String goldenBuy) {
        this.goldenBuy = goldenBuy;
    }

    public String getSuperBuy() {
        return superBuy;
    }

    public void setSuperBuy(String superBuy) {
        this.superBuy = superBuy;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", Symbol='" + Symbol + '\'' +
                ", sasiBuy='" + sasiBuy + '\'' +
                ", goldenBuy='" + goldenBuy + '\'' +
                ", superBuy='" + superBuy + '\'' +
                ", creationDate=" + creationDate +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
