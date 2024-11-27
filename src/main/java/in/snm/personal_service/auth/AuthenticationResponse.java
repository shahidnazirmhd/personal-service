package in.snm.personal_service.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {
    // TODO: Add refresh token field if required
}

