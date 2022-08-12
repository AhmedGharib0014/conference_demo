package com.gharib.conference_demo.controllers;


import com.gharib.conference_demo.models.Session;
import com.gharib.conference_demo.repositories.SessionRepository;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.SessionIdGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return  sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping(path = "/{id}")
    public Session getOne(@PathVariable Long id){
        return  sessionRepository.findById(id).get();
    }

    @PostMapping
    public  Session create(@RequestBody final  Session session){
        return  sessionRepository.saveAndFlush(session);
    }


    @RequestMapping(path = "{id}" , method = RequestMethod.DELETE)
    public  void  delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id,@RequestBody Session session){
        Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return  sessionRepository.saveAndFlush(existingSession);
    }

}
