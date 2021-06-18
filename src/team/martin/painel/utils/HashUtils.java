package team.martin.painel.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    /*
     * Realiza a função de entregar uma String criptografada em SHA-1
     */
    public String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest hash = MessageDigest.getInstance("SHA-1");
        hash.update(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash.digest()){
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}