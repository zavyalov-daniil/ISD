package com.notes.isd.services.security;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class SimplePasswordsEncoder implements ISimplePasswordsEncoder {

    private byte[] salt;

    public SimplePasswordsEncoder() {
        try {
            this.salt = generateSalt();
        } catch (Exception ex) {
            //TODO: exceptions handling
        }
    }

    @Override
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Generate an 8 byte (64 bit) salt
        byte[] salt = new byte[8];
        random.nextBytes(salt);

        return salt;
    }

    /**
     * encode string password using PBKDF2WithHmacSHA1
     * encode byte[] password into base64
     */
    @Override
    public String encryptPassword(String pass) {
        try {
            byte[] encryptedPass = getEncryptedPassword(pass, salt);
            return Base64.getEncoder().encodeToString(encryptedPass);
        } catch (NoSuchAlgorithmException ex) {
            //TODO: exceptions handling
        } catch (InvalidKeySpecException ex) {
            //TODO: exceptions handling
        } catch (Exception ex) {
        }
        return null;
    }


    /*private boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Encrypt the clear-text password using the same salt that was used to
        // encrypt the original password
        byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);

        // Authentication succeeds if encrypted password that the user entered
        // is equal to the stored hash
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
    }*/


    private byte[] getEncryptedPassword(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // PBKDF2 with SHA-1 as the hashing algorithm.
        String algorithm = "PBKDF2WithHmacSHA1";
        // SHA-1 generates 160 bit hashes
        int derivedKeyLength = 160;//TODO: Const
        //Iteration count
        int iterations = 1000;//TODO: const

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        return f.generateSecret(spec).getEncoded();
    }

    /**
     * encode byte[] salt into base64
     */
    public String getSalt() {
        String res = Base64.getEncoder().encodeToString(salt);
        return res;
    }
}
