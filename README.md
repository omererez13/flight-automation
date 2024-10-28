# Flight Automation Project

## Proje Tanımı

Bu proje, Enuygun web sitesinde uçak bileti arama ve filtreleme işlemlerini otomatikleştiren bir test otomasyon projesidir. Proje, Java programlama dili ve Selenide kütüphanesi kullanılarak geliştirilmiştir.

## Gereksinimler

- Java 8 veya üstü
- Maven 3.6 veya üstü

## Projenin Kurulumu

1. **Depoyu Klonlayın:**
    ```sh
    git clone <repository_url>
    cd flight-automation
    ```

2. **Gerekli Bağımlılıkları Yükleyin:**
    ```sh
    mvn clean install
    ```

## Projeyi Çalıştırma

1. **Testleri Çalıştırın:**
    ```sh
    mvn test
    ```

2. **Raporları Görüntüleme:**
    - Testler tamamlandıktan sonra, Surefire raporları `target/surefire-reports` klasöründe bulunacaktır.
    - `target/surefire-reports/index.html` dosyasını tarayıcınızda açarak test sonuçlarına göz atabilirsiniz.

## Kullanılan Teknolojiler ve Kütüphaneler

- **Java**: Programlama dili.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi aracı.
- **Selenide**: Web tarayıcı otomasyon kütüphanesi.
- **TestNG**: Test framework, test senaryolarını yazmak ve yürütmek için kullanılır.
- **WebDriverManager**: WebDriver yönetimi için kullanılan kütüphane.


## Proje Yapısı

```plaintext
flight-automation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── enuygun
│   │   │   │   │   ├── base
│   │   │   │   │   │   └── BaseTest.java
│   │   │   │   │   ├── helpers
│   │   │   │   │   │   └── TestHelper.java
│   │   │   │   │   ├── pages
│   │   │   │   │   │   ├── FlightListingPage.java
│   │   │   │   │   │   ├── FlightSearchPage.java
│   │   │   │   │   │   └── PersonelInformationPage.java
│   │   │   │   │   ├── utils
│   │   │   │   │   │   └── ConfigReader.java
│   ├── test
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── enuygun
│   │   │   │   │   ├── tests
│   │   │   │   │   │   └── FlightBookingTestCases.java
│   ├── resources
│   │   └── testng.xml
├── .gitignore
├── README.md
├── pom.xml
