package com.dibeksupa.supamkt;

import com.dibeksupa.supamkt.domain.*;
import com.dibeksupa.supamkt.service.RuleEngine;
import com.dibeksupa.supamkt.service.SupaRuleEngine;
import com.dibeksupa.supamkt.service.TillService;
import com.dibeksupa.supamkt.service.TillServiceImpl;
import com.sun.istack.internal.logging.Logger;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Step definition class for wordsofnumbers feature
 * Created by dibek on 03/10/15.
 */


public class SupaMktStepDefs {

    Logger log= Logger.getLogger(SupaMktStepDefs.class);

    List<Item> items = new ArrayList<Item>();

    TillServiceImpl tillService ;

    CheckOut checkOut;

    List<Rule> rules;


    RuleEngine ruleEngine;


    @Before
    public void init() {
        tillService = new TillServiceImpl();
        ruleEngine =  new SupaRuleEngine();
        rules = new ArrayList<>();
    }


    @Given("^The customer bought this items$")
    public void The_customer_bought_this_items(List<Item> items) throws Throwable {
       assertNotNull(items);
       this.items.addAll(items);
    }

    @Then("^CheckOut result will contain \"([^\"]*)\"$")
    public void CheckOut_result_will_contain(String arg1) throws Throwable {
       SupaDiscount discount =  new SupaDiscount();
        discount.setName(arg1.toUpperCase());
        assertTrue(checkOut.getMapDiscount().containsValue(discount));
        log.info("checkOut" + checkOut);
    }

    @And("^The system process the items$")
    public void The_system_process_the_items() throws Throwable {
        checkOut = tillService.processItems(items);
    }


    @And("^I apply the discount \"([^\"]*)\"$")
    public void I_apply_the_discount(String arg1) throws Throwable {
        SupaRule ruleCheapest = new SupaRule();
        ruleCheapest.setName(RuleEnum.valueOf(arg1.toUpperCase()));
        rules.add(ruleCheapest);
        ruleEngine.setRules(rules);
        tillService.setRuleEngine(ruleEngine);
    }
}
