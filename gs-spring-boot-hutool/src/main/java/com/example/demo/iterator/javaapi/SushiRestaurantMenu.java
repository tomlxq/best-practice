package com.example.demo.iterator.javaapi;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class SushiRestaurantMenu {
    private Hashtable items = new Hashtable<String, MenuItem>();

    public SushiRestaurantMenu() {
        items.put("sashimi", new MenuItem("sashimi", "生鱼片", 18f, false));
        items.put("sushi", new MenuItem("sushi", "寿司", 12f, false));
        items.put("abalone salad", new MenuItem("abalone salad", "鲍鱼沙拉", 45f, false));
    }

    public Iterator getIterator() {
        return this.items.values().iterator();
    }
}
