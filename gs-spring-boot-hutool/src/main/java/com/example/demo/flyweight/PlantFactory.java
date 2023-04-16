package com.example.demo.flyweight;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
@Slf4j
public class PlantFactory {
    HashMap<Integer, Plant> map = new HashMap<>();

    public Plant getPlant(int type) {
        if (!map.containsKey(type)) {
            switch (type) {
                case 0:
                    map.put(type, new Tree());
                    break;
                case 1:
                    map.put(type, new Grass());
                    break;
                default:
                    log.info("not support type");
                    break;
            }
        }
        return map.get(type);
    }
}
