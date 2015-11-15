package com.dibeksupa.supamkt.domain;

/**
 * Created by gdibella on 13/11/15.
 */
public class SupaDiscount implements Discount {

    private String name;

    private long idItem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupaDiscount discount = (SupaDiscount) o;

        return !(name != null ? !name.equals(discount.name) : discount.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (idItem ^ (idItem >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SupaDiscount{" +
                "name='" + name + '\'' +
                ", idItem=" + idItem +
                '}';
    }
}
