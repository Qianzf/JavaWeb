package com.senchuuhi.iweb.iextends.homekit.auth;

import com.beowulfe.hap.HomekitAuthInfo;
import com.beowulfe.hap.HomekitServer;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MockAuthInfo implements HomekitAuthInfo {

    private static final String PIN = "123-45-678";

    private final String mac;
    private final BigInteger salt;
    private final byte[] privateKey;
    private final ConcurrentMap<String, byte[]> userKeyMap = new ConcurrentHashMap<>();

    public MockAuthInfo() throws InvalidAlgorithmParameterException {
        // mac 地址
        mac = HomekitServer.generateMac();
        //
        salt = HomekitServer.generateSalt();
        privateKey = HomekitServer.generateKey();
        System.out.println("Auth info is generated each time the sample application is started. Pairings are not persisted.");
        System.out.println("校验PIN码： " + PIN);
    }

    @Override
    public String getPin() {
        return PIN;
    }

    @Override
    public String getMac() {
        return mac;
    }

    @Override
    public BigInteger getSalt() {
        return salt;
    }

    @Override
    public byte[] getPrivateKey() {
        return privateKey;
    }

    @Override
    public void createUser(String username, byte[] publicKey) {
        userKeyMap.putIfAbsent(username, publicKey);
        System.out.println("Added pairing for "+username);
    }

    @Override
    public void removeUser(String username) {
        userKeyMap.remove(username);
        System.out.println("Removed pairing for "+username);
    }

    @Override
    public byte[] getUserPublicKey(String username) {
        return userKeyMap.get(username);
    }
}
