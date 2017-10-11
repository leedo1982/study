


1 pom.xml

```
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>
```

2 datasources
```

(before)
spring:
  datasource:
    platform: mssql
    url: jdbc:sqlserver://localhost:1433;DatabaseName=TEST
    driverClassName: com.microsoft.sqlserver.jdbc.SQLServerDriver

(after)
spring:
  datasource:
    platform: mssql
    url: jdbc:log4jdbc:sqlserver://localhost:1433;DatabaseName=TEST
    driverClassName: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
```

3 log4jdbc.log4j2.properties
```
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
log4jdbc.dump.sql.maxlinelength=0
```

4.logback.xml
```
<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{yyyyMMdd HH:mm:ss.SSS} [%thread] %-3level %logger{5} - %msg %n</pattern>
    </encoder>
  </appender>

  <logger name="jdbc" level="OFF"/>

  <logger name="jdbc.sqlonly" level="OFF"/>
  <logger name="jdbc.sqltiming" level="DEBUG"/>
  <logger name="jdbc.audit" level="OFF"/>
  <logger name="jdbc.resultset" level="OFF"/>
  <logger name="jdbc.resultsettable" level="DEBUG"/>
  <logger name="jdbc.connection" level="OFF"/>

  <root level="INFO">
    <appender-ref ref="STDOUT" />
  </root>

</configuration>

```


- jdbc.sqlonly : SQL문만을 로그로 남기며, PreparedStatement일 경우 관련된 argument 값으로 대체된 SQL문이 보여진다.
- jdbc.sqltiming : SQL문과 해당 SQL을 실행시키는데 수행된 시간 정보(milliseconds)를 포함한다. 
- jdbc.audit : ResultSet을 제외한 모든 JDBC 호출 정보를 로그로 남긴다. 많은 양의 로그가 생성되므로 특별히 JDBC 문제를 추적해야 할 필요가 있는 경우를 제외하고는 사용을 권장하지 않는다.
- jdbc.resultset : ResultSet을 포함한 모든 JDBC 호출 정보를 로그로 남기므로 매우 방대한 양의 로그가 생성된다.
- jdbc.resultsettable : SQL 결과 조회된 데이터의 table을 로그로 남긴다.
