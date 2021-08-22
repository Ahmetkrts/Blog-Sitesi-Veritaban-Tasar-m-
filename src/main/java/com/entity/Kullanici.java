package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Kullanici implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String K_Adi;
    private String Password;
    private String e_mail;
    private String adi;
    private String soyadi;
    @Lob
    private String biografi;

    @OneToMany
    @JoinTable(name = "Takipci",
            joinColumns = @JoinColumn(name = "Kullanici_id"),
            inverseJoinColumns = @JoinColumn(name = "Takipci_id")
    )
    private Collection<Kullanici> takipciList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getK_Adi() {
        return K_Adi;
    }

    public void setK_Adi(String k_Adi) {
        K_Adi = k_Adi;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getBiografi() {
        return biografi;
    }

    public void setBiografi(String biografi) {
        this.biografi = biografi;
    }

    public Collection<Kullanici> getTakipciList() {
        return takipciList;
    }

    public void setTakipciList(Collection<Kullanici> takipciList) {

        this.takipciList = takipciList;
    }
}
