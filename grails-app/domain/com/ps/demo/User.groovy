package com.ps.demo

import grails.persistence.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class User implements GormEntity<User> {

    Long id
    String name
    Integer document

    static constraints = {
        name nullable: false
        document nullable: false
    }

    User(Long id, String name, Integer document) {
        this.id = id
        this.name = name
        this.document = document
    }

    User(String name, Integer document) {
        this.name = name
        this.document = document
    }
}
