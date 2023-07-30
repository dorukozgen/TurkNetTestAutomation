@desktop
Feature: TurkNet Masaüstü Websitesi Testi
  Background:
    Given "https://turk.net/" websitesine git
    And Sayfanın yüklenmesini bekle

  Scenario: Kullanıcı altyapı sorgulaması yaptıktan sonra altyapı bilgileri görüntülenir
    Given "Altyapı Sorgula" butonuna tıkla
    When "Altyapı Sorgula" sayfası yüklendiğinde
    Then "İl" alanından "İSTANBUL" seç
    And "İlçe" alanından "ADALAR" seç
    And "Mahalle" alanından "BURGAZADA" seç
    And "Cadde / Sokak" alanından "AYIŞIĞI SOKAGI" seç
    And "Bina" alanında "NO: 2_" seç
    And "Daire" alanında "/" seç
    Then "Sorgula" butonuna tıkla
    When "Sorgula" butonuna tıklandıktan sonra altyapı bilgileri sayfası yüklendiğinde
    Then Altyapı bilgileri görüntülenir


