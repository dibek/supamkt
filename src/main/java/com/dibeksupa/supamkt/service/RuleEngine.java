package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.Discount;
import com.dibeksupa.supamkt.domain.Item;
import com.dibeksupa.supamkt.domain.Rule;

import java.util.List;
import java.util.Map;

/**
 * Created by gdibella on 13/11/15.
 */
public interface RuleEngine {

    public void processRules();

    public List<Item> getItems();

    public Map<Long, Discount> getMapDiscount();

    public void setItems(List<Item> listItems);

    public void setMapDiscount(Map<Long, Discount> mapDiscount);

    public void setRules(List<Rule> rules);
}
