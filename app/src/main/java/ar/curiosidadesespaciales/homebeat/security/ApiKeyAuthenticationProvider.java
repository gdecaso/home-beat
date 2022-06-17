package ar.curiosidadesespaciales.homebeat.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {
    @Value("${HOME_BEAT_API_KEY}")
    private String apiKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apiKey = (String) authentication.getPrincipal();

        if (apiKey == null || apiKey.isBlank()) {
            throw new InsufficientAuthenticationException("No API key in request");
        } else {
            if (this.apiKey.equals(apiKey)) {
                return new ApiKeyAuthenticationToken(apiKey, true);
            }
            throw new BadCredentialsException("API Key is invalid");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
