# Swagger กับ Spring Boot

โปรเจกต์ตัวอย่างสำหรับการใช้งาน Swagger UI/OpenAPI กับ Spring Boot โดยใช้ `springdoc-openapi`

## Tech Stack

| รายการ | เวอร์ชัน/รายละเอียด |
| --- | --- |
| Java | 21 |
| Spring Boot | 3.4.3 |
| Maven | ใช้ Maven Wrapper (`./mvnw`) |
| Swagger/OpenAPI | `springdoc-openapi-starter-webmvc-ui` 2.8.5 |

## Swagger คืออะไร?

Swagger คือเครื่องมือสำหรับสร้างเอกสาร API และทดลองเรียก API ผ่านเว็บอินเทอร์เฟซได้ทันที ใน Spring Boot สามารถใช้งานผ่าน SpringDoc OpenAPI เพื่อสร้างเอกสาร OpenAPI และ Swagger UI จาก controller และ annotation ในโปรเจกต์

## การติดตั้ง Dependency

เพิ่ม dependency ของ SpringDoc OpenAPI ใน `pom.xml`

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.5</version>
</dependency>
```

เอกสารเพิ่มเติม:

- [Swagger](https://swagger.io/)
- [SpringDoc OpenAPI](https://springdoc.org/#spring-webmvc-support)
- [springdoc-openapi GitHub](https://github.com/springdoc/springdoc-openapi)

## การตั้งค่า Swagger

โปรเจกต์นี้เปิดใช้งาน profile `dev` จาก `src/main/resources/application.properties`

```properties
spring.profiles.active=dev
```

ค่าหลักของ Swagger อยู่ใน `src/main/resources/application-dev.yaml`

```yaml
server:
  port: 1919

springdoc:
  swagger-ui:
    path: /swagger
    displayRequestDuration: true
    tryItOutEnabled: true
    groupsOrder: DESC
    operations-sorter: alpha
    tags-sorter: alpha
  api-docs:
    path: /api-doc
```

### ความหมายของ Field

| Field | ความหมาย |
| --- | --- |
| `server.port` | กำหนด port ที่ใช้รันแอปพลิเคชัน |
| `springdoc.swagger-ui.path` | กำหนด URL ของ Swagger UI |
| `displayRequestDuration` | แสดงเวลาที่ใช้ในการเรียก API |
| `tryItOutEnabled` | เปิดปุ่ม Try it out เพื่อทดลองเรียก API |
| `groupsOrder` | กำหนดการเรียงลำดับกลุ่ม API |
| `operations-sorter` | กำหนดการเรียงลำดับ operation |
| `tags-sorter` | กำหนดการเรียงลำดับ tag |
| `springdoc.api-docs.path` | กำหนด URL ของ OpenAPI JSON |

## OpenAPI Configuration

กำหนดข้อมูลพื้นฐานของเอกสาร API ได้ใน `SwaggerConfig.java`

```java
@Configuration
@OpenAPIDefinition(
    info = @Info(title = "Admin API", version = "1.0", description = "API for adminstrator")
)
public class SwaggerConfig {
}
```

## Swagger Annotation ที่ใช้ในโปรเจกต์

| Annotation | ใช้กับ | คำอธิบาย |
| --- | --- | --- |
| `@OpenAPIDefinition` | Configuration class | กำหนดข้อมูลหลักของ OpenAPI เช่น title, version, description |
| `@Info` | ภายใน `@OpenAPIDefinition` | กำหนด metadata ของ API |
| `@Tag` | Controller | จัดกลุ่ม API เป็นหมวดหมู่ |
| `@Operation` | Method | ระบุ summary และ description ของ endpoint |
| `@Schema` | DTO/Record field | อธิบาย schema หรือกำหนด example ของ field |

## Demo Endpoints

Controller หลักอยู่ที่ `ApiController.java` และใช้ base path `/api`

| Method | Path | คำอธิบาย |
| --- | --- | --- |
| `GET` | `/api/getRequest` | ทดสอบ GET request |
| `POST` | `/api/postRequest` | รับ JSON body และตอบกลับข้อมูล |
| `POST` | `/api/postRequestHeader` | รับ header `X-Custom-Header` พร้อม JSON body |
| `POST` | `/api/postRequestParam` | รับ request parameter `firstname` และ `lastname` |
| `POST` | `/api/PostRequestMultipartFile` | รับ multipart file จาก field `File` และ `Image` |

ตัวอย่าง JSON body สำหรับ endpoint ที่รับ `PostModel`

```json
{
  "id": 1,
  "firstname": "Sawat",
  "lastname": "Champaine"
}
```

## การรันโปรเจกต์

ตรวจสอบให้เครื่องใช้ JDK 21 ก่อนรันโปรเจกต์

```bash
java -version
```

รันด้วย Maven Wrapper

```bash
sh ./mvnw spring-boot:run
```

หลังจากรันสำเร็จ สามารถเข้าใช้งานได้ที่:

- Swagger UI: <http://localhost:1919/swagger>
- OpenAPI JSON: <http://localhost:1919/api-doc>

## การทดสอบ

รัน test ด้วยคำสั่ง:

```bash
sh ./mvnw test
```

ถ้า `mvnw` มี execute permission แล้ว สามารถใช้ `./mvnw spring-boot:run` และ `./mvnw test` ได้เช่นกัน
