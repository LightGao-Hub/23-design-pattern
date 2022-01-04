package org.example.design.principle.fourth;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-10
 */
public class TestFourth {
    @Test
    public void test() {
        StuScoreList.INSTANCE.insert();
        StuScoreList.INSTANCE.countTotalScore();
        StuScoreList.INSTANCE.printStuInfo();
        StuScoreList.INSTANCE.delete();
    }
}
