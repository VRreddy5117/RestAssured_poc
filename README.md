
ALLURE REST ASSURED             |  
:-------------------------:|
![allure](https://github.com/sevilayagil/AllureRestAssured/blob/master/Grey%20Circles%20Gaming%20Youtube%20Channel%20Art.png)  |  




> Proje örnek bir rest servisin get ve post requestleriyle api testlerinin yazılması ve rest assured ile entegrasyonu ile oluşturulmuştur.


----------
# Gereklilikler
- Allure
- Rest Assured 
- TESTNG


----------
# ALLURE Kurulum 
Windows Powershell'i açın ve önce scoopu sonrasında ise allureyi sisteminize kurun

```
$ iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
$ scoop install allure

```
----------
# POM.XML
Projede allure ve rest assured kullanmak için pom.xml'de aşağıdaki gibi rest assured ve allurenin dependencyleri eklenmelidir.

## 

```xml
 <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-rest-assured</artifactId>
            <version>2.13.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-maven -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.9</version>
        </dependency>
```
----------
# Nasıl Kullanabilirim  :information_desk_person:
![powershell](https://github.com/sevilayagil/AllureRestAssured/blob/master/powershell.png)  |  


> Terminalizde önce aşağıdaki gibi maven komutunu yazın. Bu işlemden sonra raporunuz target altında allure results klasoru altında oluşacaktır.

```
$  mvn clean test

```
> Raporu ayağa kaldırmak için ise yine terminalinizde  allure serve komutunu yazın.
```
$ allure serve C:\kullanıcıadı\proje lokasyonu \target\allure-results

```
----------
# Raporlama  :bar_chart:

![rapor](https://github.com/sevilayagil/AllureRestAssured/blob/master/allure.png)  |  ![rapor2](https://github.com/sevilayagil/AllureRestAssured/blob/master/Screenshot_1.png)  |  


# Jenkins Plugin
```
Allure Jenkins Plugin

```






