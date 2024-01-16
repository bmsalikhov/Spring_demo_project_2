package ru.syn.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.syn.demo2.services.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService service;

    @GetMapping()
    public Boolean getRootTest() {
        return false;
    }

    @GetMapping("/getApple/{count}")
    public List<String> getApple(@PathVariable("count") int count) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(service.appleName +" #" + i);
        }
        return res;
    }

    @PostMapping("/setAppleName")
    public boolean setAppleName(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("name")) {
                return service.setAppleName(((String) body.get("name")));
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @GetMapping("/getUserBio")
    public List<String> getUserBio() {
        ArrayList<String> res = new ArrayList<>();
        res.add(service.userFirstName);
        res.add(service.userLastName);
        return res;
    }

    @PostMapping("/setUserBioToUpperCase")
    public boolean setUserBioToUpperCase(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("firstName") && body.containsKey("lastName")) {
                return service.setUserBioToUpperCase(((String) body.get("firstName")), ((String) body.get("lastName")));
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @PostMapping("/setUserBioToLowerCase")
    public boolean setUserBioToLowerCase(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("firstName") && body.containsKey("lastName")) {
                return service.setUserBioToLowerCase(((String) body.get("firstName")), ((String) body.get("lastName")));
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
