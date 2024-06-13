package com.fullstackapp.taskmanagemantsystem.service;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JWTUtils {

    private SecretKey key;

    private static final long EXPIRATION_TIME = 86400000;  //24 hours

    public JWTUtils(){
        String secretsString = "";
        byte[] keyBytes = Base64.getDecoder().decode(secretsString.getBytes(StandardCharsets.UTF_8));
    }
}
