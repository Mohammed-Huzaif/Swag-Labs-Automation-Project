package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojo.CustomerInformation;

import java.util.Locale;

public class FakeInformationUtility {

    public static CustomerInformation getFakeInfo() {
        Faker faker = new Faker(Locale.US);

        CustomerInformation customerInformation =
                new CustomerInformation(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.numerify("####"));

        return customerInformation;
    }


}
