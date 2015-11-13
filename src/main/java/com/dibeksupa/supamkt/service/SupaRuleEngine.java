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
                Map<Long,Item> itemsMap = countTripletSameItem(listItems);
                for (Map.Entry<Long,Item> entry : itemsMap.entrySet()){
                    SupaDiscount discount =  new SupaDiscount();
                    discount.setName(rule.getName().toString());
                    mapDiscount.put(entry.getKey(),discount);
                }
        }

    }

    private Map<Long,Item> countTripletSameItem(List<Item> items) {
        Map<Long,Item> itemsTripletMap = new HashMap<Long, Item>();
        int count = 0;
        Item itemCheck= new Item();
        for (Item item: items) {
            if (itemCheck.equals(item)){
                count++;
                if (count == 3) {
                    itemsTripletMap.put(((Item)item).getId(), (Item)item);
                    count = 0;
                    itemCheck= new Item();
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
