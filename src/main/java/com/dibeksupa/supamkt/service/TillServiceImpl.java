package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.CheckOut;
import com.dibeksupa.supamkt.domain.Discount;
import com.dibeksupa.supamkt.domain.Item;
import com.dibeksupa.supamkt.domain.SupaCheckOut;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gdibella on 13/11/15.
 */
public class TillServiceImpl implements TillService {

    RuleEngine ruleEngine;

    public RuleEngine getRuleEngine() {
        return ruleEngine;
    }

    public void setRuleEngine(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public CheckOut processItems(List<Item> listItems) {
        Map<Long,Discount> mapDiscount = new HashMap();
        ruleEngine.setItems(listItems);
        ruleEngine.setMapDiscount(mapDiscount);
        ruleEngine.processRules();
        SupaCheckOut checkOut = new SupaCheckOut();
        checkOut.setItems(listItems);
        checkOut.setMapDiscount(mapDiscount);
        return checkOut;
    }

    public String printCheckOut(SupaCheckOut checkOut){
        return checkOut.toString();
    }
}
