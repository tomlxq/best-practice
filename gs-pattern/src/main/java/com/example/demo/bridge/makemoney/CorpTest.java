package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class CorpTest {
    public static void main(String[] args) {
        System.out.println("~~~~~~山寨公司是这样运作的~~~~~~");
        Corp fakeCorp = new FakeCorp(new Mobile());
        fakeCorp.makeMoney();
        System.out.println("~~~~~~房产公司是这样运作的~~~~~~");
        Corp houseCorp = new HouseCorp(new House());
        houseCorp.makeMoney();
        System.out.println("~~~~~~员工养不活，干点副业，房产公司是这样运作的~~~~~~");
        houseCorp = new HouseCorp(new Mobile());
        houseCorp.makeMoney();
        System.out.println("~~~~~~旅游赚钱，房产公司是这样运作的~~~~~~");
        houseCorp = new HouseCorp(new Tour());
        houseCorp.makeMoney();
    }
}
