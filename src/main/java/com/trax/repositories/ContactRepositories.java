package com.trax.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax.entities.Contacts;

public interface ContactRepositories extends JpaRepository<Contacts, Long> {

}
