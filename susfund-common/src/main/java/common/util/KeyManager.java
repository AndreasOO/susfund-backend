package common.util;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class KeyManager {

    private static final String KEY_ALGORITHM = "HmacSHA256";
    private static Key signingKey;

    private KeyManager() {

    }

    public static Key getSigningKey() throws NoSuchAlgorithmException {
        if (signingKey == null) {
            signingKey = getKeyFromKeyGenerator();
        }
        return signingKey;
    }

    private static Key getKeyFromKeyGenerator() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
}
