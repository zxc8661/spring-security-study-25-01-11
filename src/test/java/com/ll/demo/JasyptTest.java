package com.ll.demo;


import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;



@Slf4j
public class JasyptTest {

    @Test
    public void jasyptText() {
        String value = "lldj123414";
        String result = jasyptEncoding(value);
        log.debug("---{}---", result);
        System.out.println(result);
    }

    public String jasyptEncoding(String value){
        String key ="612A2AA99D8A49E4E5EA8F2CB3E41";
        StandardPBEStringEncryptor pbeEnc=new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
