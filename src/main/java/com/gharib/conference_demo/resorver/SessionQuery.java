package com.gharib.conference_demo.resorver;
import com.gharib.conference_demo.models.Session;
import com.gharib.conference_demo.repositories.SessionRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
class SessionQuery  implements GraphQLQueryResolver {
    private  SessionRepository sessionRepository;

    public SessionQuery(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }



    public Iterable<Session>findAllSessions(){
        return sessionRepository.findAll();
    }



    public  Session findById(Long id){
        // you should handle not found error
        return  sessionRepository.findById(id).get();
    }



}
