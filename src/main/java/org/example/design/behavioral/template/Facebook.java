package org.example.design.behavioral.template;

import static org.example.design.config.FinalConfig.TEN_SIZE;
import static org.example.design.config.FinalConfig.ZERO;

import java.util.stream.IntStream;

import lombok.extern.log4j.Log4j2;
import org.example.design.config.FinalConfig;

/**
 *  Facebook通讯子类, 实现父类逻辑
 *
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class Facebook extends Network {

    public Facebook(String userName, String password) {
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
        log.info("LogIn success on Facebook");
        return true;
    }

    public void sendData(byte[] data) {
        log.info(String.format("Message: '%s' - was posted on Facebook", new String(data)));
    }

    public void logOut() {
        log.info(String.format("User: '%s' - was logged out from Facebook", this.getUserName()));
    }

    // 模拟网络延迟
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
