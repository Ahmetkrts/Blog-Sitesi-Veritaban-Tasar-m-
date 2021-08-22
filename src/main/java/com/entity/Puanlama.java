package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Puanlama implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private float deger;
    @OneToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getDeger() {
        return deger;
    }

    public void setDeger(float deger) {
        this.deger = deger;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
}
