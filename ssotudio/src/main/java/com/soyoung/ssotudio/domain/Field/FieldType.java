package com.soyoung.ssotudio.domain.Field;

import lombok.Getter;

@Getter
public enum FieldType {
    alert("alert"),
    async_description("async_description"),
    async_image("async_image"),
    border("border"),
    checkbox("checkbox"),
    date("date"),
    date_range("date_range"),
    description("description"),
    file("file"),
    hidden("hidden"),
    hstack("hstack"),
    number("number"),
    link("link"),
    list("list"),
    password("password"),
    radio("radio"),
    stepper("stepper"),
    text("text"),
    textarea("textarea"),
    tab("tab"),
    toggle("toggle"),
    select("select"),
    multi_select("multi_select"),
    tree_select("tree_select"),
    multi_tree_select("multi_tree_select"),
    bank_account_select("bank_account_select");

    private final String value;

    FieldType(String value) {
        this.value = value;
    }

}
