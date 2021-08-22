package com.entity;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Gorseller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String URL;
    private String baslik;
    private String altBilgi;
    private String boyut;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAltBilgi() {
        return altBilgi;
    }

    public void setAltBilgi(String altBilgi) {
        this.altBilgi = altBilgi;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
