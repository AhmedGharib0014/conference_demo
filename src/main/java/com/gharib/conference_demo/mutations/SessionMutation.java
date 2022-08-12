package com.gharib.conference_demo.mutations;


import com.gharib.conference_demo.models.Session;
import com.gharib.conference_demo.repositories.SessionRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

import org.springframework.stereotype.Component;

@Component
public class SessionMutation implements GraphQLMutationResolver {
    private SessionRepository sessionRepository;

    public SessionMutation(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session newSession(Long session_id,String session_name,String session_description,int  session_length){
        Session newsession=new Session();
        newsession.setSession_id(session_id);
        newsession.setSession_name(session_name);
        newsession.setSession_description(session_description);
        newsession.setSession_length(session_length);
        return  sessionRepository.saveAndFlush(newsession);

    }

    public Boolean  deleteSession(Long id){
        sessionRepository.deleteById(id);
        return true ;
    }

}
