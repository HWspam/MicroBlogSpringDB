package com.example;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erikjakubowski on 12/21/16.
 */

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    MessageRepository messsages;

    @Autowired
    UserRepo users;


    @RequestMapping(path="/", method = RequestMethod.GET)
    public String person(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        User d = users.findFirstByName((String) session.getAttribute("userName"));

        List<Message> messList = (List<Message>)messsages.findByUser(d);
        model.addAttribute("messages", messList);
        return "person";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String each (HttpSession session, String user) {
        session.setAttribute("userName", user);
        User a = users.findFirstByName(user);
        if(a == null) {
            a = new User(user);
            users.save(a);

        }
        return "redirect:/";
    }

    @RequestMapping(path="/add-message", method = RequestMethod.POST)
    public String sub(String messageText, HttpSession session) {
        String a = (String) session.getAttribute("userName");
        User b = users.findFirstByName(a);


        Message mess = new Message (messageText, b);
        messsages.save(mess);



        return "redirect:/";


    }


    @RequestMapping(path = "/editmessage", method =  RequestMethod.POST)
    public String edutmessage(Model model, int Id, String edit) {
        Message message = messsages.findOne(Id);
        message.messageText = edit;
        messsages.save(message);
        return "redirect:/";

    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delSub(Model model, int id) {
        messsages.delete(id);
        return "redirect:/";
    }
}
