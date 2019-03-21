package com.mkh.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Value("${config.oauth2.privateKey}")
    private String privateKey;

    @Value("${config.oauth2.publicKey}")
    private String publicKey;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);

//        clients.inMemory()
//                .withClient("client").secret("secret")
//                .authorizedGrantTypes("authorization_code")
//                .accessTokenValiditySeconds(20000)
//                .refreshTokenValiditySeconds(20000)
//                .scopes("read")
//                .redirectUris("http://localhost:8082/client")
//
//                .and().
//
//                withClient("client_credential").secret("secret")
//                .authorizedGrantTypes("client_credentials","password")
//                .accessTokenValiditySeconds(20000)
//                .refreshTokenValiditySeconds(20000)
//                .scopes("read");
    }


    /** jwt token config **/
    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenConverter());
    }
//

//    /**
//     * 1 - 필수 확인 (tokenStore)
//     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(new InMemoryTokenStore()).authen;
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(tokenConverter()) // /check_token 에서 사용됨
                .userDetailsService(userDetailsService)
                .tokenEnhancer(tokenConverter());  // resource server에서 사용됨
    }
//
//    /**
//     * 2 - 필수 확인
//     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauth) throws Exception {
        oauth.tokenKeyAccess("isAnonymous() || hasRole('ROLE_USER')") // permitAll()
                .checkTokenAccess("hasRole('ROLE_USER')"); // isAuthenticated()
//        oauth.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    /** jwt token config **/
}
