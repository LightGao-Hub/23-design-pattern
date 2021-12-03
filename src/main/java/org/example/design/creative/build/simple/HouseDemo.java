package org.example.design.creative.build.simple;


import lombok.Getter;

/**
 * @Builder注解实现原理
 *
 * Author: GL
 * Date: 2021-12-02
 */
@Getter
public class HouseDemo {
    // 必选
    private int windows;
    private int doors;
    private int rooms;
    // 可选
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasGarden;

    // 核心代码
    public static HouseDemo.HouseDemoBuilder builder() {
        return new HouseDemo.HouseDemoBuilder();
    }

    public HouseDemo(int windows, int doors, int rooms, boolean hasGarage, boolean hasSwimPool, boolean hasGarden) {
        this.windows = windows;
        this.doors = doors;
        this.rooms = rooms;
        this.hasGarage = hasGarage;
        this.hasSwimPool = hasSwimPool;
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "HouseDemo{" + "windows=" + windows + ", doors=" + doors + ", rooms=" + rooms + ", hasGarage=" + hasGarage + ", hasSwimPool=" + hasSwimPool + ", hasGarden=" + hasGarden + '}';
    }

    // 核心静态类
    public static class HouseDemoBuilder {
        private int windows;
        private int doors;
        private int rooms;
        private boolean hasGarage;
        private boolean hasSwimPool;
        private boolean hasGarden;

        HouseDemoBuilder(){
        }

        public HouseDemo build() {
            return new HouseDemo(this.windows, this.doors, this.rooms, this.hasGarage, this.hasSwimPool, this.hasGarden);
        }

        public HouseDemo.HouseDemoBuilder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseDemo.HouseDemoBuilder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public HouseDemo.HouseDemoBuilder rooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public HouseDemo.HouseDemoBuilder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseDemo.HouseDemoBuilder hasSwimPool(boolean hasSwimPool) {
            this.hasSwimPool = hasSwimPool;
            return this;
        }

        public HouseDemo.HouseDemoBuilder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

    }
}
