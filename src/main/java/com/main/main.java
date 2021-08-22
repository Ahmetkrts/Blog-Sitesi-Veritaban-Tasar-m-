package com.main;

import com.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class main {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Kullanici kullanici = new Kullanici();
        Kullanici kullanici2 = new Kullanici();

        Profil profil = new Profil();

        Gorseller profilGorsel = new Gorseller();

        Kategoriler kategori = new Kategoriler();

        Etiketler etiket = new Etiketler();

        Puanlama puan = new Puanlama();

        Yorum yorum = new Yorum();
        Yorum yorum1 = new Yorum();

        Yazilar yazi = new Yazilar();

        kullanici.setAdi("ahmet");
        kullanici.setK_Adi("23olmaz34");
        kullanici.setSoyadi("karataş");
        kullanici.setPassword("12345");
        kullanici.setE_mail("ahmet50.karatas@gmail.com");
        kullanici.setBiografi("bilgisayar adamı ");
        kullanici.getTakipciList().add(kullanici2);

        profil.setBaslik(kullanici.getAdi() + " Profili");
        profil.setKullanici(kullanici);
        profil.setBiografi(kullanici.getBiografi());
        profil.setOlusturmaTarihi(new Date());
        profil.setGorsel(profilGorsel);

        profilGorsel.setBaslik(profil.getBaslik() + " Gorseli");
        profilGorsel.setBoyut("1920x1080");
        profilGorsel.setAltBilgi(profil.getKullanici().getAdi() + " kullanıcısının profil fotografı");
        profilGorsel.setURL("https://picsum.photos/200/300");

        kategori.setBaslik("Teknoloji");
        kategori.setAciklama("Teknoloji haberleri ve Son Dakika");

        etiket.setBaslik("Folksdev");
        etiket.setAciklama("teknoloji uzmanı");

        puan.setDeger(10);
        puan.setKullanici(kullanici);

        yorum1.setKullanici(kullanici2);
        yorum1.setBaslik("Folksdev ve Harika içerikleri ne Cevap");
        yorum1.setIcerik("Söylediklerinizde Çok Haklısınız hemen takip ediyorum kanalı");
        yorum1.setOlusturma_Tarihi(new Date());

        yorum.setKullanici(kullanici);
        yorum.setBaslik("Folksdev ve Harika içerikleri");
        yorum.setIcerik("Folksdev kanalı Spring Boot ve Java içinb harika içerikler üretiyor kesinlikle takipte kalın");
        yorum.setOlusturma_Tarihi(new Date());
        yorum.getYorum_cevap().add(yorum1);

        yazi.setBaslik("İlk Folsdev Yazısı");
        yazi.setAciklama("folksdev kanalı harika");
        yazi.setIcerik("Lorem Ipsum is simply dummy " +
                "text of the printing and typesetting " +
                "industry. Lorem Ipsum has been the industry's" +
                " standard dummy text ever since the 1500s, when " +
                "an unknown printer took a galley of type and scrambled" +
                " it to make a type specimen book. It has survived not" +
                " only five centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. ");

        yazi.setGorsel(profilGorsel);
        yazi.setKullanici(kullanici);
        yazi.getKategori_list().add(kategori);
        yazi.getEtiket_list().add(etiket);
        yazi.getYorumList().add(yorum);
        yazi.getPuanList().add(puan);


        session.save(kullanici2);
        session.save(kullanici);
        session.save(profil);
        session.save(profilGorsel);
        session.save(kategori);
        session.save(etiket);
        session.save(puan);
        session.save(yorum);
        session.save(yorum1);
        session.save(yazi);
        session.getTransaction().commit();
        session.close();
    }
}
