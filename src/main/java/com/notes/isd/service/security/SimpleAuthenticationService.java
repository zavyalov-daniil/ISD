package com.notes.isd.service.security;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class SimpleAuthenticationService implements ISimpleAuthenticationService {

    private byte[] salt;

    public SimpleAuthenticationService() {

    }

    @Override
    public void setSalt(final byte[] salt) {
        this.salt = salt;
    }

    @Override
    public byte[] getSalt() throws NullPointerException {
        if (salt.length <= 0) {
            throw new NullPointerException("salt is empty");
        }
        return salt;
    }

    @Override
    public boolean matchPasswords(String incomingPassword, String savedPassword) throws Exception {
        if (salt.length <= 0) {
            throw new NullPointerException("salt is empty");
        }
        byte[] incoming = getEncryptedPassword(incomingPassword);
        byte[] saved = Base64.getDecoder().decode(savedPassword);
        return Arrays.equals(saved, incoming);
    }

    private byte[] getEncryptedPassword(final String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // PBKDF2 with SHA-1 as the hashing algorithm.
        String algorithm = "PBKDF2WithHmacSHA1";//TODO: Const
        // SHA-1 generates 160 bit hashes
        int derivedKeyLength = 160;//TODO: Const
        //Iteration count
        int iterations = 1000;//TODO: const

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        return f.generateSecret(spec).getEncoded();
    }
}
