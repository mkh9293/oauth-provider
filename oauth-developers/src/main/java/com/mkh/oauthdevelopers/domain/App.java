package com.mkh.oauthdevelopers.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="oauth_client_details")
public class App {
    @Size(max=256)
    @Column(name="client_id")
    @Id
    private String clientId;

    @Size(max=256)
    @Column(name="resource_ids")
    private String resourceIds;

    @JsonIgnore
    @Size(max=256)
    @Column(name="client_secret")
    private String clientSecret;

    @Size(max=256)
    @Column(name="scope")
    private String scope;

    @Size(max=256)
    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes;

    @Size(max=256)
    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;

    @Size(max=256)
    @Column(name="authorities")
    private String authorities;

    @Size(max=256)
    @Column(name="access_token_validity")
    private String accessTokenValidity;

    @Size(max=256)
    @Column(name="refresh_token_validity")
    private String refreshTokenValidity;

    @Size(max=256)
    @Column(name="additional_information")
    private String additionalInformation;

    @Size(max=256)
    @Column(name="autoapprove")
    private String autoapprove;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(String accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public String getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(String refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
