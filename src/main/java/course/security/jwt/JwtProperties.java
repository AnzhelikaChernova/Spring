package course.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jwt")
@Getter
@RequiredArgsConstructor
public class JwtProperties {
    private final String key;
    private final Long accessTokenExpiration;
    private final Long refreshTokenExpiration;
}
