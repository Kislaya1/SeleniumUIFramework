package com.auto.selenium.ui.enums.pim;

public enum PIMPageNavOptions {
    CONFIGURATION("Configuration"),
    EMPLOYEE_LIST("Employee List"),
    ADD_EMPLOYEE("Add Employee"),
    REPORTS("Reports");
    private String navOptions;
    PIMPageNavOptions(final String navOptions) {
        this.navOptions = navOptions;
    }
    public String getOptions() {
        return this.navOptions;
    }
}
