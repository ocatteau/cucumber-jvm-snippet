package fr.stateofmind.cucumber;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositStepDefinitions {

    private Account account;
    private User user;


    @Before(value = "@UserAccounts")
    public void initialize() {
        if (user == null) {
            user = new User();
        }

        if (account == null) {
            account = new Account();
            user.setAccount(account);
        }
    }

    @Given("^a User has no money in their account$")
    public void a_User_has_no_money_in_their_account() throws Throwable {
        assertThat("The balance is not zero.", account.getBalance(), equalTo(0));
    }

    @When("^(\\d+)euro is deposited in to the account$")
    public void euro_is_deposited_in_to_the_account(int depositedAmount) throws Throwable {
        account.deposit(depositedAmount);
    }

    @Then("^the balance should be (\\d+)euro$")
    public void the_balance_should_be_euro(int expectedBalance) throws Throwable {
        assertThat("The expected balance was " + expectedBalance + "€, but actually was: " + account.getBalance(),
                   account.getBalance(), equalTo(expectedBalance));
    }
}
