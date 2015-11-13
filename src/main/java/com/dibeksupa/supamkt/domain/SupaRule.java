package com.dibeksupa.supamkt.domain;


/**
 * Created by gdibella on 13/11/15.
 */
public class SupaRule implements  Rule{

    private RuleEnum name;

    public RuleEnum getName() {
        return name;
    }

    public void setName(RuleEnum name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupaRule supaRule = (SupaRule) o;

        return name == supaRule.name;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SupaRule{" +
                "name=" + name +
                '}';
    }
}
