package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.CheckOut;
import com.dibeksupa.supamkt.domain.Item;

import java.util.List;

/**
 * Created by gdibella on 13/11/15.
 */
public interface TillService {

    public CheckOut processItems(List<Item> listItems);
}
