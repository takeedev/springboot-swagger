# swagger กับ spring boot

## Swagger คืออะไร?
Swagger เป็นเครื่องมือที่ช่วย **สร้าง เอกสาร API อัตโนมัติ** โดยสามารถ **ทดสอบ API ได้ทันที** ผ่านเว็บอินเทอร์เฟซ Spring Boot ใช้ **SpringDoc OpenAPI** เพื่อทำให้การสร้าง Swagger ง่ายขึ้น

## 1. ติดตั้ง Swagger ใน Spring Boot  
เพิ่ม dependencies ใน `pom.xml`  
> สามารถดูเพิ่มเติมได้ที่ document
* [swagger.io](https://swagger.io/)
* [spring docs](https://springdoc.org/#spring-webmvc-support)
* [github springdoc-openapi](https://github.com/springdoc/springdoc-openapi)

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
        <version>2.8.5</version>
    </dependency> 

## 2. เพิ่มการตั้งค่าใน application.yaml
* สามารถกำหนดปรับแต่งสิ่งที่ต้องการใน swagger ได้
    ```yaml
    springdoc:
        swagger-ui:
            path: /swagger
            groupsOrder: DESC
            tags-sorter: alpha
            tryItOutEnabled: true
            operations-sorter: alpha
            displayRequestDuration: true
        api-docs:
            path: /api-doc

### ความหมายแต่ละ field ใน application.yaml
field | ความหมาย
------| ------|
path | กำหนดเส้นทาง (URL) ของ Swagger UI (ค่าเริ่มต้นคือ /swagger-ui.html)
groupsOrder | กำหนดการเรียงของกลุ่ม API ถ้ามีหลายอัน (เช่น ASCENDING , DESCENDING)
tags-sorter | กำหนดการเรียงลำดับของ tags (ค่าที่ใช้ได้: alpha หรือ method)
tryItOutEnabled | เปิด/ปิดปุ่ม Try it out (ใช้สำหรับทดสอบ API)
operations-sorter | กำหนดการเรียงลำดับของ operations (ค่าที่ใช้ได้: alpha หรือ method)
displayRequestDuration | แสดงระยะเวลาที่ใช้ในการ request หรือไม่
api-docs | กำหนดเส้นทาง (URL) ของ Swagger UI (ค่าเริ่มต้นคือ /v3/api-doc)

> สามารถดูเพิ่มเติมได้ที่ document
* [javadoc](https://javadoc.io/doc/org.springdoc/springdoc-openapi-common/1.5.9/org/springdoc/core/AbstractSwaggerUiConfigProperties.html)

## 4 เพิ่ม configulation ที่ java file
* กำหมดข้อมูลเพิ่มเติมของ swagger
    ```java
    @Configuration
    @OpenAPIDefinition(
        info = @Info(title = "Admin API", version = "1.0", description = "API for adminstrator")
    )
    public class SwaggerConfig {
    
    }
    ```
## 4 ทดสอบ api ผ่าน swagger
* สามารถเข้าผ่าน URL ตามตัวอย่างด้วยล่าง
    ```
    localhost:xxxx/swagger
    ```
