package top.yxy.boot.file.utils;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Configuration
public class MinIoTemplate {
    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient client;

    @PostConstruct
    public void init(){
        client=MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey,secretKey)
                .build();
    }

    //判断bucket 是否存在
    public boolean bucketExists(String bucketName) throws Exception {
        return client.bucketExists(BucketExistsArgs
                .builder()
                .bucket(bucketName)
                .build());
    }

    //创建 bucket
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if (!flag) {
            client.makeBucket(MakeBucketArgs
                    .builder()
                    .bucket(bucketName)
                    .build());
        }

    }
    //上传
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception{
        return client.putObject(
                PutObjectArgs
                        .builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream,-1,1048784784)
                        .build()
        );
    }
}


