package com.mkh.clientserver.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

@RestController
public class UserController {
    @Value("${config.oauth2.resourceUri}")
    private String resourceUri;

    @Autowired
    private OAuth2RestOperations restTemplate;

    @RequestMapping("/")
    public JsonNode home(){
        return restTemplate.getForObject(resourceUri, JsonNode.class);
    }

    @RequestMapping("/implicit2")
    public String implicit(){
        String CLIENT_ID = "client"; // 해당 앱의 REST API KEY 정보. 개발자 웹사이트의 대쉬보드에서 확인 가능
        String REDIRECT_URI = "http://localhost:8082/client"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능


        final String AUTH_HOST = "http://localhost:8081";
        final String tokenRequestUrl = AUTH_HOST + "/oauth/authorize?response_type=token&redirect_uri="+REDIRECT_URI+"&client_id="+CLIENT_ID+"&scope=read";

        HttpURLConnection conn = null;
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        InputStreamReader isr= null;

        try {
            String encoding = Base64.getEncoder().encodeToString(("client:secret").getBytes());

            final String params = String.format("response_type=token&redirect_uri=%s&client_id=%s&scope=read"
            , REDIRECT_URI, CLIENT_ID);

            final URL url = new URL(tokenRequestUrl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic "+encoding);
            conn.setDoOutput(true);

            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(params);
            writer.flush();

            final int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + tokenRequestUrl);
            System.out.println("Post parameters : " + params);
            System.out.println("Response Code : " + responseCode);

            isr = new InputStreamReader(conn.getInputStream());
            reader = new BufferedReader(isr);
            final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
            if (writer != null) {
                try {
                    writer.close();
                } catch(Exception ignore) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch(Exception ignore) {
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch(Exception ignore) {
                }
            }
        }
        return null;
    }

    @RequestMapping("/client_credentials")
    public void credentials() {
        final String AUTH_HOST = "http://localhost:8081";
        final String tokenRequestUrl = AUTH_HOST + "/oauth/token";

        String CLIENT_ID = "client"; // 해당 앱의 REST API KEY 정보. 개발자 웹사이트의 대쉬보드에서 확인 가능
        String REDIRECT_URI = "http://localhost:8082/client"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능

        HttpURLConnection conn = null;
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        InputStreamReader isr= null;

        try {
            String encoding = Base64.getEncoder().encodeToString(("client:secret").getBytes());

            final String params = String.format("grant_type=client_credentials");

            final URL url = new URL(tokenRequestUrl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic "+encoding);
            conn.setDoOutput(true);

            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(params);
            writer.flush();

            final int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + tokenRequestUrl);
            System.out.println("Post parameters : " + params);
            System.out.println("Response Code : " + responseCode);

            isr = new InputStreamReader(conn.getInputStream());
            reader = new BufferedReader(isr);
            final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            System.out.println(buffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
            if (writer != null) {
                try {
                    writer.close();
                } catch(Exception ignore) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch(Exception ignore) {
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch(Exception ignore) {
                }
            }
        }
    }

    @RequestMapping("/password")
    public void credentials(@RequestParam String name, @RequestParam String pass) {
        final String AUTH_HOST = "http://localhost:8081";
        final String tokenRequestUrl = AUTH_HOST + "/oauth/token";

        String CLIENT_ID = "client"; // 해당 앱의 REST API KEY 정보. 개발자 웹사이트의 대쉬보드에서 확인 가능
        String REDIRECT_URI = "http://localhost:8082/client"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능

        HttpURLConnection conn = null;
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        InputStreamReader isr= null;

        try {
            String encoding = Base64.getEncoder().encodeToString(("client:secret").getBytes());

            final String params = String.format("grant_type=password&username=%s&password=%s"
            ,name, pass);

            final URL url = new URL(tokenRequestUrl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic "+encoding);
            conn.setDoOutput(true);

            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(params);
            writer.flush();

            final int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + tokenRequestUrl);
            System.out.println("Post parameters : " + params);
            System.out.println("Response Code : " + responseCode);

            isr = new InputStreamReader(conn.getInputStream());
            reader = new BufferedReader(isr);
            final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            System.out.println(buffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
            if (writer != null) {
                try {
                    writer.close();
                } catch(Exception ignore) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch(Exception ignore) {
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch(Exception ignore) {
                }
            }
        }
    }

}
