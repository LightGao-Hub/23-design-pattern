package org.example.design.principle.four;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-13
 */
public class FourTest {
    @Test
    public void test() {
        StuScoreList.INSTANCE.insert();
        StuScoreList.INSTANCE.countTotalScore();
        StuScoreList.INSTANCE.printStuInfo();
        StuScoreList.INSTANCE.delete();
    }
}
