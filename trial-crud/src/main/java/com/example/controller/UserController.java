package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/")
    public String viewHome(Model model) {
        List<User> list = userDao.list();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        if (user.getId() == 0)
            userDao.save(user);
        else
            userDao.update(user);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id:\\d+}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        User user = userDao.get(id);
        model.addAttribute("user", user);
        return "form";
    }

    @RequestMapping("/delete/{id:\\d+}")
    public String delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/sort/name")
    public String viewSortedByName(Model model) {
        List<User> list = userDao.listSortedByName();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/sort/country")
    public String viewSortedByCountry(Model model) {
        List<User> list = userDao.listSortedByCountry();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/search/name", method = RequestMethod.GET)
    public String searchByName(@RequestParam("q") String name, Model model) {
        List<User> list = userDao.searchByName(name);
        model.addAttribute("list", list);
        model.addAttribute("searching", true);
        return "list";
    }

    @RequestMapping(value = "/search/country", method = RequestMethod.GET)
    public String searchByCountry(@RequestParam("q") String country, Model model) {
        List<User> list = userDao.searchByCountry(country);
        model.addAttribute("list", list);
        model.addAttribute("searching", true);
        return "list";
    }
}
