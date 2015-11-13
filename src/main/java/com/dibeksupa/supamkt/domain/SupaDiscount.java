package com.dibeksupa.supamkt.domain;

/**
 * Created by gdibella on 13/11/15.
 */
public class SupaDiscount implements Discount {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupaDiscount that = (SupaDiscount) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SupaDiscount{" +
                "name='" + name + '\'' +
                '}';
    }
}
