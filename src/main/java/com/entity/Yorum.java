package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Yorum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    private Date olusturma_Tarihi;
    private String baslik;
    @Lob
    private String icerik;
    @OneToMany
    @JoinTable(name = "yorum_cevap",
            joinColumns = @JoinColumn(name = "yorum_id"),
            inverseJoinColumns = @JoinColumn(name = "cevap_id")
    )
    private List<Yorum> yorum_cevap = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Date getOlusturma_Tarihi() {
        return olusturma_Tarihi;
    }

    public void setOlusturma_Tarihi(Date olusturma_Tarihi) {
        this.olusturma_Tarihi = olusturma_Tarihi;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public List<Yorum> getYorum_cevap() {
        return yorum_cevap;
    }

    public void setYorum_cevap(List<Yorum> yorum_cevap) {
        this.yorum_cevap = yorum_cevap;
    }
}
