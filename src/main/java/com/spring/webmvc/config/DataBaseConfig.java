package com.spring.webmvc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 데이터베이스 연결 설정을 하는 클래스
@Configuration
@ComponentScan(basePackages = "com.spring.webmvc")
public class DataBaseConfig {

    // 접속 정보 객체 빈 등록 (DataSource 객체)
    @Bean
        // 이 데이터 소스 메서드를 통해 반환되는 히카리 소스 객체마저 빈에 등록되어있으므로 서버 실행시 객체 생성됨. = 커넥션 풀 활성화
    public DataSource dataSource() {

        // 커넥션 풀 : 데이터베이스 연결 객체를 모아둔 곳
        HikariConfig config = new HikariConfig(); // 커넥션 풀을 생성해주는 히카리 설정 정보를 담을 객체 생성
        config.setUsername("spring4"); // 사용하는 DB (Oracle)에서 어떤 id로 로그인하여 DB를 다룰지 명시.
        config.setPassword("1234");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // 접속하고자 하는 DB가 설치된 경로 명시.
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver"); // 자바와 해당 DBMS가 연동하기 위해 필요한 드라이버
                                                                    // 드라이버 파일이 불특정 유저(클라이언트)의 접근을 막는
                                                                    // WEB-INF/lib 경로에 먼저 들어있어야 함.

        return new HikariDataSource(config);
    }
}
