package com.dibeksupa.supamkt.domain;

import com.dibeksupa.supamkt.domain.CheckOut;

import java.util.List;
import java.util.Map;

/**
 * Created by gdibella on 13/11/15.
 */
public class SupaCheckOut implements CheckOut {


    private List<Item> items;
    private Map<Long,Discount> mapDiscount;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<Long, Discount> getMapDiscount() {
        return mapDiscount;
    }

    public void setMapDiscount(Map<Long, Discount> mapDiscount) {
        this.mapDiscount = mapDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupaCheckOut that = (SupaCheckOut) o;

        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        return !(mapDiscount != null ? !mapDiscount.equals(that.mapDiscount) : that.mapDiscount != null);

    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (mapDiscount != null ? mapDiscount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SupaCheckOut{" +
                "items=" + items +
                ", mapDiscount=" + mapDiscount +
                '}';
    }
}
