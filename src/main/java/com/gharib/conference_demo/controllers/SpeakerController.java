package com.gharib.conference_demo.controllers;

import com.gharib.conference_demo.models.Speaker;
import com.gharib.conference_demo.repositories.SpeakerRepository;
import java.util.List;

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
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return  speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping(path = "/{id}")
    public Speaker getOne(@PathVariable Long id){
        return  speakerRepository.findById(id).get();
    }

    @PostMapping
    public  Speaker create(@RequestBody final  Speaker speaker){
        return  speakerRepository.saveAndFlush(speaker);
    }


    @RequestMapping(path = "/{id}" , method = RequestMethod.DELETE)
    public  void  delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(path = "/{}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id,@RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker,existingSpeaker,"session_id");
        return  speakerRepository.saveAndFlush(existingSpeaker);
    }

}
