## TurkNet Masaüstü Ve Mobil Test Otomasyonu Projesi

TurkNet resmi web sitesi için hazırlanmış olan masaüstü ve mobil test otomasyonu projesidir. Bu projede Java + Cucumber + JUnit 5 + Selenium WebDriver + Appium teknolojileri kullanılmıştır.

#### İndirme ve Çalıştırma

- Projeyi klonlayın.
- Projeyi Intellij IDEA ile çalıştırın.
- `pom.xml` dosyasındaki gerekli modülleri yükleyiniz.
- `src\test\java\DesktopTestRunner.java` veya `src\test\java\MobileTestRunner.java` sınıf dosyasını çalıştırınız.

#### Raporlama

- Çıkan sonuçları;
    - `target\cucumber-reports\DesktopTestReport.html` dosyasından masaüstü testleri için görüntüleyebilirsiniz.
    - `target\cucumber-reports\MobileTestReport.html` dosyasından mobil testleri için görüntüleyebilirsiniz.

#### Gerekenler

- JDK 11 veya üst sürümü
- Apache Maven 3 veya üst sürümü