package com.local.latihan.repository;

import com.local.latihan.entity.Contact;
import com.local.latihan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> {

    Optional<Contact> findFirstByUserAndId(User user, String id);

}
