package course.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collection;
import java.util.Date;

import static java.util.stream.Collectors.joining;

@Component
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private final Key secretKey;
    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    public JwtUtil(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.secretKey = Keys.hmacShaKeyFor(jwtProperties.getKey().getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Authentication authentication) {

        String username = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        var claims = Jwts.claims().setSubject(username);
        if (!authorities.isEmpty()) {
            claims.put("roles", authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(joining(","))
            );
        }

        Date now = new Date();
        Date validity = new Date(now.getTime() + this.jwtProperties.getAccessTokenExpiration());

        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
                .signWith(this.secretKey, SignatureAlgorithm.HS256).compact();

    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();

        Object authoritiesClaim = claims.get("roles");

        Collection<? extends GrantedAuthority> authorities = authoritiesClaim == null
                ? AuthorityUtils.NO_AUTHORITIES
                : AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesClaim.toString());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(this.secretKey)
                    .build().parseClaimsJws(token);
            logger.info("expiration date: {}", claims.getBody().getExpiration());
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            logger.info("Invalid JWT token: {}", e.getMessage());
            logger.trace("Invalid JWT token trace.", e);
        }
        return false;
    }
}
