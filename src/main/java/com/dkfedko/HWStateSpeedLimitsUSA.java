package com.dkfedko;

public enum HWStateSpeedLimitsUSA {
    ALABAMA(65, "I50", 102.5),
    IOWA(65, "I35", 305.4),
    NEVADA(65, "I25", 209.5),
    MICHIGAN(0, null, 0) ,
    OHIO(65, "I40", 405.6),
    FLORIDA(65, "I600", 284.6),
    MAINE(65, "I85", 45.5),
    TEXES(65, "I10", 105.5);
    final String HWName;
    final int speedLimit;
    final double roadMileLength;

    HWStateSpeedLimitsUSA (int speedLimit, String HWName, double roadMileLength){
        this.speedLimit = speedLimit;
        this.HWName = HWName;
        this.roadMileLength = roadMileLength;

    }
}
