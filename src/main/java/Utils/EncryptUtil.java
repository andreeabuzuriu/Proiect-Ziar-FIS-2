package Utils;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.*;

public class EncryptUtil
{
    private static String pass="myPass";
    public static String encrypt(String str)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(pass);
        String encrypted= encryptor.encrypt(str);
        return encrypted;
    }


    public static String decrypt(String str)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(pass);

        String decrypted = encryptor.decrypt(str);
        return decrypted;
    }
}