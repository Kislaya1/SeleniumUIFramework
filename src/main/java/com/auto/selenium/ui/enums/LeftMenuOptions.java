package com.auto.selenium.ui.enums;

public enum LeftMenuOptions {
    PIM("PIM"),
    ADMIN("Admin"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");
    private final String menuOption;

    LeftMenuOptions(final String menuOption) {
        this.menuOption = menuOption;
    }

    public String getName() {
        return menuOption;
    }
}
