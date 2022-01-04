package org.example.design.behavioral.visitor.require.first;

import lombok.extern.log4j.Log4j2;

/**
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class SubWest2 extends West {
    @Override
    public void goWest(SubEast1 east) {

        log.info("SubWest2 + " + east.myName1());
    }

    @Override
    public void goWest(SubEast2 east) {

        log.info("SubWest2 + " + east.myName2());
    }
}
