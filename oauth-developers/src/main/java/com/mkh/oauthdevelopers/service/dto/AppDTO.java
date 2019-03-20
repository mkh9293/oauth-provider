package com.mkh.oauthdevelopers.service.dto;

import javax.validation.constraints.Size;

public class AppDTO {

    @Size(max=256)
    private String clientId;

    @Size(max=256)
    private String resourceIds;

    @Size(max=256)
    private String clientSecret;

    @Size(max=256)
    private String scope;

    @Size(max=256)
    private String authorizedGrantTypes;

    @Size(max=256)
    private String webServerRedirectUri;

    @Size(max=256)
    private String authorities;

    @Size(max=256)
    private String accessTokenValidity;

    @Size(max=256)
    private String refreshTokenValidity;

    @Size(max=256)
    private String additionalInformation;

    @Size(max=256)
    private String autoapprove;

    public AppDTO(@Size(max = 256) String clientId, @Size(max = 256) String resourceIds, @Size(max = 256) String clientSecret, @Size(max = 256) String scope, @Size(max = 256) String authorizedGrantTypes, @Size(max = 256) String webServerRedirectUri, @Size(max = 256) String authorities, @Size(max = 256) String accessTokenValidity, @Size(max = 256) String refreshTokenValidity, @Size(max = 256) String additionalInformation, @Size(max = 256) String autoapprove) {
        this.clientId = clientId;
        this.resourceIds = resourceIds;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.webServerRedirectUri = webServerRedirectUri;
        this.authorities = authorities;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
        this.additionalInformation = additionalInformation;
        this.autoapprove = autoapprove;
    }

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

    @Override
    public String toString() {
        return "AppDTO{" +
                "clientId='" + clientId + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", authorizedGrantTypes='" + authorizedGrantTypes + '\'' +
                ", webServerRedirectUri='" + webServerRedirectUri + '\'' +
                ", authorities='" + authorities + '\'' +
                ", accessTokenValidity='" + accessTokenValidity + '\'' +
                ", refreshTokenValidity='" + refreshTokenValidity + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", autoapprove='" + autoapprove + '\'' +
                '}';
    }
}
