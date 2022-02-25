package com.trader.oneCrore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CHILD")
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "SYMBOL")
    private String Symbol;

    @Column(name = "SASIBUY")
    private String SasiBuy;

    @Column(name = "GOLDENBUY")
    private String GoldenBuy;

    @Column(name = "SUPERBUY")
    private String SuperBuy;

    @Column(name = "CREATIONDATE")
    private String creationDate;

    @Column(name = "TIMESLOT")
    private String timeslot;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    @ManyToOne
    @JoinColumn(name = "stock_symbol")
    private Stock stock;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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

    public void setSasiBuy(String SasiBuy) {
        this.SasiBuy = SasiBuy;
    }

    public String getSasiBuy() {
        return SasiBuy;
    }

    public void setGoldenBuy(String GoldenBuy) {
        this.GoldenBuy = GoldenBuy;
    }

    public String getGoldenBuy() {
        return GoldenBuy;
    }

    public void setSuperBuy(String SuperBuy) {
        this.SuperBuy = SuperBuy;
    }

    public String getSuperBuy() {
        return SuperBuy;
    }

    @Override
    public String toString() {
        return "CHILD{" +
                "Symbol=" + Symbol + '\'' +
                "SasiBuy=" + SasiBuy + '\'' +
                "GoldenBuy=" + GoldenBuy + '\'' +
                "SuperBuy=" + SuperBuy + '\'' +
                '}';
    }
}
