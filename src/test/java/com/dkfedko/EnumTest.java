package com.dkfedko;


public class EnumTest {
    public static void main(String[] args) {
        System.out.println(HWStateSpeedLimitsUSA.IOWA.HWName + " HW length " + HWStateSpeedLimitsUSA.IOWA.roadMileLength);
        System.out.println("Ohio " + HWStateSpeedLimitsUSA.OHIO.HWName + " speed limit " + HWStateSpeedLimitsUSA.OHIO.speedLimit);
        System.out.println(HWStateSpeedLimitsUSA.TEXES.compareTo(HWStateSpeedLimitsUSA.ALABAMA));
        System.out.println(HWStateSpeedLimitsUSA.IOWA.describeConstable());
        System.out.println(HWStateSpeedLimitsUSA.FLORIDA.name());
        System.out.println(HWStateSpeedLimitsUSA.FLORIDA.ordinal());
        System.out.println(HWStateSpeedLimitsUSA.NEVADA.ordinal());
        System.out.println(HWStateSpeedLimitsUSA.values()[2]);
    }
}
