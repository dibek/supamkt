package com.dibeksupa.supamkt;

import com.dibeksupa.supamkt.domain.*;
import com.dibeksupa.supamkt.service.RuleEngine;
import com.dibeksupa.supamkt.service.SupaRuleEngine;
import com.dibeksupa.supamkt.service.TillService;
import com.dibeksupa.supamkt.service.TillServiceImpl;
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


    List<Item> items = new ArrayList<Item>();

    TillServiceImpl tillService ;

    CheckOut checkOut;

    @Before
    public void init() {
        tillService = new TillServiceImpl();
        RuleEngine ruleEngine =  new SupaRuleEngine();
        List<Rule> rules  =  new ArrayList<Rule>();
        SupaRule rule3x2 = new SupaRule();
        rule3x2.setName(RuleEnum.THREEXTWO);
        rules.add(rule3x2);
        ruleEngine.setRules(rules);
        tillService.setRuleEngine(ruleEngine);

    }


    @Given("^The customer bought this items$")
    public void The_customer_bought_this_items(List<Item> items) throws Throwable {
       assertNotNull(items);
    }

    @Then("^CheckOut result will contain \"([^\"]*)\"$")
    public void CheckOut_result_will_contain(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^The system process the items$")
    public void The_system_process_the_items() throws Throwable {
        checkOut = tillService.processItems(items);
    }



}
