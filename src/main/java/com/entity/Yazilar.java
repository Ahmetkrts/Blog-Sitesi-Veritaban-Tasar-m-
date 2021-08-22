package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Yazilar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String baslik;
    private String aciklama;
    @Lob
    private String icerik;

    @OneToOne
    @JoinColumn(name = "kapak_gorsel_id")
    private Gorseller gorsel;

    private Date degistirme_tarihi;


    @ManyToOne
    @JoinTable(name = "yazar",
            joinColumns = @JoinColumn(name = "yazi_id"),
            inverseJoinColumns = @JoinColumn(name = "kullanici_id")
    )
    private Kullanici kullanici;


    @ManyToMany
    @JoinTable(name = "yazi_kategori",
            joinColumns = @JoinColumn(name = "yazi_id"),
            inverseJoinColumns = @JoinColumn(name = "kategori_id")
    )
    private List<Kategoriler> kategori_list=new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "yazi_etiket",
            joinColumns = @JoinColumn(name = "yazi_id"),
            inverseJoinColumns = @JoinColumn(name = "etiket_id")
    )
    private List<Etiketler> etiket_list=new ArrayList<>();


    @OneToMany
    @JoinTable(name = "yazi_yorum",
            joinColumns = @JoinColumn(name = "yazi_id"),
            inverseJoinColumns = @JoinColumn(name = "yorum_id")
    )
    private List<Yorum> yorumList=new ArrayList<>();

    @OneToMany
    @JoinTable(name = "yazi_puan",
            joinColumns = @JoinColumn(name = "yazi_id"),
            inverseJoinColumns = @JoinColumn(name = "puan_id")
    )
    private List<Puanlama> puanList=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Gorseller getGorsel() {
        return gorsel;
    }

    public void setGorsel(Gorseller gorsel) {
        this.gorsel = gorsel;
    }

    public Date getDegistirme_tarihi() {
        return degistirme_tarihi;
    }

    public void setDegistirme_tarihi(Date degistirme_tarihi) {
        this.degistirme_tarihi = degistirme_tarihi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kategoriler> getKategori_list() {
        return kategori_list;
    }

    public void setKategori_list(List<Kategoriler> kategori_list) {
        this.kategori_list = kategori_list;
    }

    public List<Etiketler> getEtiket_list() {
        return etiket_list;
    }

    public void setEtiket_list(List<Etiketler> etiket_list) {
        this.etiket_list = etiket_list;
    }

    public List<Yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(List<Yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public List<Puanlama> getPuanList() {
        return puanList;
    }

    public void setPuanList(List<Puanlama> puanList) {
        this.puanList = puanList;
    }
}
