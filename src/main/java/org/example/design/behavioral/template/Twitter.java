package org.example.design.behavioral.template;

import static org.example.design.config.FinalConfig.TEN_SIZE;
import static org.example.design.config.FinalConfig.ZERO;

import java.util.stream.IntStream;

import lombok.extern.log4j.Log4j2;
import org.example.design.config.FinalConfig;

/**
 *  推特通讯子类, 实现父类逻辑
 *
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class Twitter extends Network {


    public Twitter(String userName, String password) {
        super(userName, password);
    }

    public boolean logIn(String userName, String password) {
        log.info("Checking user's parameters");
        log.info("Name: " + this.getUserName());
        System.out.print("Password: ");
        for (int i = 0; i < this.getPassword().length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        log.info("LogIn success on Twitter");
        return true;
    }

    public void sendData(byte[] data) {
        log.info("Message: '" + new String(data) + "' was posted on Twitter");
    }

    public void logOut() {
        log.info("User: '" + this.getUserName() + "' was logged out from Twitter");
    }

    private void simulateNetworkLatency() {
        IntStream.range(ZERO, TEN_SIZE).forEach(v -> {
            log.info(".");
            try {
                Thread.sleep(FinalConfig.ONE_HUNDRED_SIZE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
