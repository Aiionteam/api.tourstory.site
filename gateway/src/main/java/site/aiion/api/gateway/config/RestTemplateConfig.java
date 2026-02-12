package site.aiion.api.gateway.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Spring Boot 3.4.0 이후 setConnectTimeout/setReadTimeout이 deprecated되었으므로
        // ClientHttpRequestFactory를 직접 설정
        // 타임아웃: 연결 15초, 읽기 300초 (LangGraph 채팅/RAG 첫 요청 시 온톨로지·GPT·모델 초기화로 지연 가능)
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout((int) Duration.ofSeconds(15).toMillis());
        factory.setReadTimeout((int) Duration.ofSeconds(300).toMillis()); // 5분 (채팅 프록시용)
        
        return builder
            .requestFactory(() -> factory)
            .build();
    }
}

