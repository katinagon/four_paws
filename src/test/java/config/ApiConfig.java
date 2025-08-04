package config;

import org.aeonbits.owner.Config;

public interface ApiConfig extends Config {
    @Key("baseURI")
    @DefaultValue("https://4lapy.ru")
    String baseURI();

    @Key("apiBaseURI")
    @DefaultValue("https://api.4lapy.ru")
    String apiBaseURI();

    @Key("apiAuthEP")
    @DefaultValue("/api/v1/users/customer/auth")
    String authEP();

    @Key("apiCurrentUserEP")
    @DefaultValue("/api/v1/users/current")
    String currentUserEP();

    @Key("apiCustomerCartIdEP")
    @DefaultValue("/api/v1/cart/customerCartId?customerId=")
    String customerCartIdEP();

    @Key("apiCartEP")
    @DefaultValue("/api/v1/cart/cart/")
    String cartEP();

    @Key("apiAuthByEmailEP")
    @DefaultValue("/api/auth/authByEmail/")
    String authByEmailEP();
}
