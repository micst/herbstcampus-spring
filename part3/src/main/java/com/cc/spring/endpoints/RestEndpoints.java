package com.cc.spring.endpoints;
//package com.cc.spring.domain;

import com.cc.spring.backend.ExampleBackend;
import com.cc.spring.domain.Produkt;
import com.cc.spring.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestEndpoints {

    @GetMapping("/hello")
    public String haveFun(@RequestParam(value = "name", required = false) String name)
    {
        return "having fun with " + name;
    }

    @PostMapping("/hello")
    public int  PostName(@RequestParam(value = "name", required = true) String name)
    {
        System.out.println("name: " + name);
        return 201;
    }

    @PutMapping("/hello/{name}")
    public int PutName(@PathVariable(name = "name") String name)
    {
        System.out.println("oops: " + name);
        return 204;
    }

    @RequestMapping(value = "/produkt.json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Produkt myProduct(@RequestBody  User user)
    {
        System.out.println("haha1");
        Produkt p = ExampleBackend.berechneImBackend(user);
        return p;
    }

    @RequestMapping(value = "/produkt.xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Produkt myProduct2(@RequestBody  User user)
    {
        System.out.println("haha1");
        Produkt p = ExampleBackend.berechneImBackend(user);
        return p;
    }
}
