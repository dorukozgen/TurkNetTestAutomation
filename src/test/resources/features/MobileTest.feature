@mobile
Feature: TurkNet Mobil Uygulaması Testi
  Scenario: Kullanıcı uygulama üzerinden bilgilerini doldurarak giriş yapar
    Given Bildirim ekranından bildirimlere izin ver
    Then TC kimlik numarası alanına "10000000000" gir
    And Şifre alanına "123456" gir
    And "Devam Et" butonuna tıkla
    Then Giriş yapabildiğini kontrol et