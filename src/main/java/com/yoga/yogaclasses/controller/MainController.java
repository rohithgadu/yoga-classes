package com.yoga.yogaclasses.controller;

import com.yoga.yogaclasses.advice.DateException;
import com.yoga.yogaclasses.model.User;
import com.yoga.yogaclasses.repository.UserRepository;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Temporal(TemporalType.DATE)
    Date currDate=new Date(System.currentTimeMillis());

    private Map<Integer, String> getMap(){
        Map<Integer,String> mp=new HashMap<>();
        mp.put(1,"6AM-7AM");
        mp.put(2,"7AM-8AM");
        mp.put(3,"8AM-9AM");
        mp.put(4,"5PM-6PM");
        return mp;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Authentication authentication, Model model) {
        Map<Integer,String> mp=getMap();
        String email= authentication.getName();
        User user=userRepository.findByEmail(email);

        String name= user.getName();
        String time=mp.get(user.getYogaTime());
        model.addAttribute("name",name);
        model.addAttribute("time",time);
        return "index";
    }

    @GetMapping("/change")
    public String getChange(Authentication authentication, Model model) throws DateException {
        Map<Integer,String> mp=getMap();
        String email= authentication.getName();
        User user=userRepository.findByEmail(email);

        Date userDate=user.getDate();

        long dateBeforeInMs = userDate.getTime();
        long dateAfterInMs = currDate.getTime();

        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        if(daysDiff>=28){
            return "change";
        }
        else{
            throw new DateException();
        }
    }


}
