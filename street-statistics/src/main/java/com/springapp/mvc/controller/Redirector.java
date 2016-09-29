package com.springapp.mvc.controller;


import org.springframework.web.servlet.view.RedirectView;

public class Redirector {

    public RedirectView redirectToMainPage() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/");
        return redirectView;
    }
}
