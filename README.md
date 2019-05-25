# oauth-provider

### 1. 개별 모듈 나누어서 구현
jwt (json web token), jks(java key store) 이용

-- 구현 리스트 
1.  client credentails grant
2. authorization code grant
3. resource owner password grant
4.  implicit code grant

-- 모듈

 - auth-server  (인증서버 모듈)
 - client-server (클라이언트 모듈)
 - resource-server (리소스서버 모듈)
---

<br>

### 2. 하나의 모듈로 구현

-- 구현 리스트
1.  client credentails grant

-- 모듈
 - auth-resource-server (인증 + 리소스 서버 모듈)
---


### 참고
1. https://tools.ietf.org/html/rfc6749
2. https://projects.spring.io/spring-security-oauth/docs/oauth2.html
