package com.mh.api.MhAPI.config;

import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class MinIOConfig {

   @Value("${minio.accessKey}")
    private String accessKey;
   @Value("${minio.secretKey}")
   private String secretKey;
   @Value("${minio.endpoint}")
   private String endpoint;


   @Bean
   public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
