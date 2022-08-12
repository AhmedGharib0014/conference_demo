package com.gharib.conference_demo.repositories;

import com.gharib.conference_demo.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface SessionRepository extends JpaRepository<Session,Long> {
}
