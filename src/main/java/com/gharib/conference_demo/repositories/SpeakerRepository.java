package com.gharib.conference_demo.repositories;

import com.gharib.conference_demo.models.Speaker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
