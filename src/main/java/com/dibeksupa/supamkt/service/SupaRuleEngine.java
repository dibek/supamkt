package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.*;

import java.util.*;

/**
 * Created by gdibella on 13/11/15.
 */
public class SupaRuleEngine implements RuleEngine {

    private List<Item> items;
    private Map<Long,Discount> mapDiscount;
    List<Rule> rules ;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> listItems) {
        this.items = listItems;
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
            dispatch(rule, items,mapDiscount);
        }
    }

    private void dispatch(Rule rule, List<Item> listItems, Map<Long, Discount> mapDiscount) {
        Collections.sort(listItems,new ItemComparator());
        switch (rule.getName()) {
            case THREEXTWO:
                Map<Long,SupMktItem> itemsMap = countTripletSameItem(listItems);
        }

    }

    private Map<Long,SupMktItem> countTripletSameItem(List<Item> items) {
        Map<Long,SupMktItem> itemsTripletMap = new HashMap<Long, SupMktItem>();
        int count = 0;
        Item itemCheck= new SupMktItem();
        for (Item item: items) {
            if (itemCheck.equals(item)){
                count++;
                if (count == 3) {
                    itemsTripletMap.put(((SupMktItem)item).getId(), (SupMktItem)item);
                    count = 0;
                    itemCheck= new SupMktItem();
                }
            }
            itemCheck = item;
        }
        return itemsTripletMap;
    }


    @Override
    public String toString() {
        return "SupaRuleEngine{" +
                "items=" + items +
                ", mapDiscount=" + mapDiscount +
                '}';
    }
}
