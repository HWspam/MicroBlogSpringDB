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

    ArrayList<Message> submitted = new ArrayList<Message>();

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String person(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        List<Message> messList = (List<Message>)messsages.findAll();
        model.addAttribute("messages", messList);
        return "person";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String each (HttpSession session, String user  ) {
        session.setAttribute("userName", user);
        return "redirect:/";
    }

    @RequestMapping(path="/add-message", method = RequestMethod.POST)
    public String sub(String messageText, HttpSession session) {

        Message mess = new Message (messageText);


        submitted.add(mess);

        return "redirect:/";


    }


    @RequestMapping(path = "/editmessage", method =  RequestMethod.POST)
    public String edutmessage(Model model, int Id, String edit) {
        Message message = messsages.findOne(Id);
        message.messageText = edit;
        submitted.add(message);

        return "redirect:/";

    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delSub(Model model, int id) {
        submitted.remove(id);


        return "redirect:/";
    }
}
