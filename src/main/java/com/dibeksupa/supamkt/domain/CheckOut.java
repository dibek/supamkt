package com.dibeksupa.supamkt.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by gdibella on 13/11/15.
 */
public interface CheckOut {

    List<Item> getItems();
    Map<Long,Discount> getMapDiscount();

}
