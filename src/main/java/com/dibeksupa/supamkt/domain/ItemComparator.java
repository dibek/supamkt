package com.dibeksupa.supamkt.domain;

import java.util.Comparator;

/**
 * Created by gdibella on 13/11/15.
 */
public class ItemComparator implements Comparator<Item> {
    public int compare(Item itm1, Item itm2) {
        return itm1.getName().compareTo(itm2.getName());
    }
}
