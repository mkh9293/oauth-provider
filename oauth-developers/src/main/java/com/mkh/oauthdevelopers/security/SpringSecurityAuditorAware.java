package com.mkh.oauthdevelopers.security;

import com.mkh.oauthdevelopers.config.Constants;
import com.mkh.oauthdevelopers.service.util.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getCurrentUserLogin().orElse(Constants.SYSTEM_ACCOUNT));
    }
}
