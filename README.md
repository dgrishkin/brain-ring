Для запуска проекта необходимо в корне создать файл **dasource.poperties**

Пример:
```
spring.datasource.url=  
spring.datasource.username=  
spring.datasource.password=
```
В конфигурации запуска указать параметр **-Dspring.config.additional-location=datasource.properties**