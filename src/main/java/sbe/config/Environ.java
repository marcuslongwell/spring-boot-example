package sbe.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Environ {
    @Value("${sbe.cors.origins}")
    @Getter
    private String allowedCorsOrigins;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    @Getter
    private String oauthIssuerUri;
}
