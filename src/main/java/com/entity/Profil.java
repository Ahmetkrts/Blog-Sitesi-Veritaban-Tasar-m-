package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Profil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date olusturmaTarihi;
    @OneToOne
    @JoinColumn(name = "gorsel_Id")
    private Gorseller gorsel;

    @OneToOne
    @JoinColumn(name = "kullanici_Id")
    private Kullanici kullanici;

    @Lob
    private String biografi;

    private String baslik;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOlusturmaTarihi() {
        return olusturmaTarihi;
    }

    public void setOlusturmaTarihi(Date olusturmaTarihi) {
        this.olusturmaTarihi = olusturmaTarihi;
    }

    public Gorseller getGorsel() {
        return gorsel;
    }

    public void setGorsel(Gorseller gorsel) {
        this.gorsel = gorsel;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public String getBiografi() {
        return biografi;
    }

    public void setBiografi(String biografi) {
        this.biografi = biografi;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
}
