package com.springapp.mvc;

import com.springapp.mvc.entity.Country;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        getInfo1();
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @Transactional
    private List<Country> getInfo1() {
        Session session = sessionFactory.getCurrentSession();
        List<Country> countries = getCountries(session);
        System.out.println("Size: " + countries.size() + "\n");
        for (Country country : countries) {
            System.out.println(country.getName());
        }
        return null;
    }

    @Transactional
    private List<Country> getCountries(Session session) {
        Criteria criteria = session.createCriteria(Country.class).add(Restrictions.eq("id", 1));
        return criteria.list();
    }
}