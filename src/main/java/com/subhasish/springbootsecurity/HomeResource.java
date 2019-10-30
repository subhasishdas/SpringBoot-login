package com.subhasish.springbootsecurity;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

//    @GetMapping("/")
//    public String home() {
//        return ("<h1>Welcome</h1>");
//    }
    @RequestMapping("/")
    public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
        URI bakapp = new URI("http://bakapp.herokuapp.com");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(bakapp);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
