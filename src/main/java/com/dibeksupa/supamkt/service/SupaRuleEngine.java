package com.dibeksupa.supamkt.service;

import com.dibeksupa.supamkt.domain.*;

import java.util.*;

/**
 * Created by gdibella on 13/11/15.
 *
 Using an internal dispatch for testing purposes.
 In production production can be delegated to a proper rule engine reading from text files rules

 */
public class SupaRuleEngine implements RuleEngine {

    private List<Item> items;

    private Map<Long, Discount> mapDiscount;

    List<Rule> rules;

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
            dispatch(rule, items, mapDiscount);

        }
    }

    private void dispatch(Rule rule, List<Item> listItems, Map<Long, Discount> mapDiscount) {

        Collections.sort(listItems, new ItemComparator());
        Map<Long, Item> itemsMap = new HashMap<>();
        switch (rule.getName()) {
            case THREEXTWO:
                itemsMap = countTripletSameItem(listItems);

                break;
            case CHEAPEASTOFTHREEXFREE:
                itemsMap = cheapestOfThree(listItems);

                break;
            case DISCOUNTX2:
                itemsMap = countDiscount2X(listItems);

                break;
            case COUPONDISCOUNT:
                itemsMap = couponDiscount(listItems);

                break;
            default:

        }
        for (Map.Entry<Long, Item> entry : itemsMap.entrySet()) {
            SupaDiscount discount = new SupaDiscount();
            discount.setName(rule.getName().toString());
            discount.setIdItem(entry.getValue().getId());
            mapDiscount.put(entry.getKey(), discount);
        }
    }

    private Map<Long, Item> couponDiscount(List<Item> items) {
        Map<Long, Item> itemsTripletMap = new HashMap<Long, Item>();
        int count = 1;
        Item itemCheck = new Item();
        for (Item item : items) {
            if (itemCheck.equals(item)) {
                count++;
            } else if (count > 1) {
                itemsTripletMap.put(((Item) item).getId(), (Item) item);
                count = 0;
                itemCheck = new Item();
            }

            itemCheck = item;
        }
        return itemsTripletMap;
    }

    private Map<Long, Item> countDiscount2X(List<Item> items) {
        Map<Long, Item> itemsTripletMap = new HashMap<Long, Item>();
        int count = 1;
        Item itemCheck = new Item();
        for (Item item : items) {
            if (itemCheck.equals(item)) {
                count++;
                if (count == 2) {
                    itemsTripletMap.put(((Item) item).getId(), (Item) item);
                    count = 0;
                    itemCheck = new Item();
                }
            }
            itemCheck = item;
        }
        return itemsTripletMap;
    }

    private Map<Long, Item> countTripletSameItem(List<Item> items) {
        Map<Long, Item> itemsTripletMap = new HashMap<Long, Item>();
        int count = 1;
        Item itemCheck = new Item();
        for (Item item : items) {
            if (itemCheck.equals(item)) {
                count++;
                if (count == 3) {
                    itemsTripletMap.put(((Item) item).getId(), (Item) item);
                    count = 0;
                    itemCheck = new Item();
                }
            }
            itemCheck = item;
        }
        return itemsTripletMap;
    }

    private Map<Long, Item> cheapestOfThree(List<Item> items) {
        Map<Long, Item> itemsTripletMap = new HashMap<Long, Item>();
        int count = 1;
        long priceItem = 0;
        Item itemCheck = new Item();
        Item itemDiscount = new Item();
        for (Item item : items) {
            if (item.isDiscount() && !item.equals(itemCheck)) {
                if (itemCheck.getPrice() > item.getPrice()) {
                    itemDiscount = item;
                } else {
                    itemDiscount = itemCheck;
                }

                count++;
                if (count == 3) {
                    itemsTripletMap.put(((Item) itemDiscount).getId(), (Item) itemDiscount);
                    count = 0;
                    itemCheck = new Item();
                    itemDiscount = new Item();
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
