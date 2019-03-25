package com.mkh.clientserver.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public final class RequestOauth {
    public static String requestOauth(String...args) {
        final String AUTH_HOST = "http://172.30.3.107:8081";
        final String tokenRequestUrl = AUTH_HOST + "/oauth/token";
        String REDIRECT_URI = "http://172.30.3.107:8082/client/"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능

        HttpURLConnection conn = null;
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        InputStreamReader isr= null;

        try {
            String encoding = Base64.getEncoder().encodeToString(("client:secret").getBytes());

            String grantType = args[0];
            String params = "";
            if(grantType.equals("authorization_code")) {
                params = String.format("grant_type=authorization_code&code=%s&redirect_uri=%s", args[1], REDIRECT_URI);
            } else if (grantType.equals("password")) {
                params = String.format("grant_type=password&username=%s&password=%s" ,args[1], args[2]);
            } else if (grantType.equals("client_credentials")){
                params = String.format("grant_type=client_credentials");
            } else {
                params = String.format("grant_type=refresh_token&refresh_token=%s", args[1]);
            }

            final URL url = new URL(tokenRequestUrl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic "+encoding);
            conn.setDoOutput(true);

            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(params);
            writer.flush();

            final int responseCode = conn.getResponseCode();

            isr = new InputStreamReader(conn.getInputStream());
            reader = new BufferedReader(isr);
            final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            System.out.println(buffer.toString());
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
}
