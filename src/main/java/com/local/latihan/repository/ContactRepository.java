package com.local.latihan.repository;

import com.local.latihan.entity.Contact;
import com.local.latihan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> , JpaSpecificationExecutor<Contact> {

    Optional<Contact> findFirstByUserAndId(User user, String id);

}
