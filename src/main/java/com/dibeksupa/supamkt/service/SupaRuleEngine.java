package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.Discount;
import com.dibeksupa.supamkt.domain.Item;
import com.dibeksupa.supamkt.domain.ItemComparator;
import com.dibeksupa.supamkt.domain.Rule;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by gdibella on 13/11/15.
 */
public class SupaRuleEngine implements RuleEngine {

    private List<Item> listItems;
    private Map<Long,Discount> mapDiscount;
    List<Rule> rules ;

    public List<Item> getItems() {
        return listItems;
    }

    public void setItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public Map<Long, Discount> getMapDiscount() {
        return mapDiscount;
    }

    public void setMapDiscount(Map<Long, Discount> mapDiscount) {
        this.mapDiscount = mapDiscount;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public void processRules() {
        for (Rule rule : getRules()) {
            dispatch(rule,listItems,mapDiscount);
        }
    }

    private void dispatch(Rule rule, List<Item> listItems, Map<Long, Discount> mapDiscount) {
        Collections.sort(listItems,new ItemComparator());
        switch (rule.getName()) {
            case THREEXTWO:
                List<Item> listTriplet = countTripletSameItem(listItems);
        }

    }

    private List<Item> countTripletSameItem(List<Item> listItems) {
        return null;
    }

    @Override
    public String toString() {
        return "SupaRuleEngine{" +
                "listItems=" + listItems +
                ", mapDiscount=" + mapDiscount +
                '}';
    }
}
