
ALLURE REST ASSURED             |  
:-------------------------:|
![allure](https://github.com/sevilayagil/AllureRestAssured/blob/master/github/Grey%20Circles%20Gaming%20Youtube%20Channel%20Art.png)  |  



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
$ Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh')
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
Plugin kısmına ise Junit eklenmelidir. Ben JUnit4 entegre ettim.
```xml
 <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.20</version>
                <configuration>
                    <testFailureIgnore>false</testFailureIgnore>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>
                    <properties>
                        <property>
                            <name>listener</name>
                            <value>io.qameta.allure.junit4.AllureJunit4</value>
                        </property>
                    </properties>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>${aspectj.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
```

 
----------
# Nasıl Kullanabilirim  :information_desk_person:
![powershell](https://github.com/sevilayagil/AllureRestAssured/blob/master/github/ezgif.com-video-to-gif.gif)  


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

![rapor](https://github.com/sevilayagil/AllureRestAssured/blob/master/github/report.gif)  | 


# Jenkins Plugin
```
Allure Jenkins Plugin

```






