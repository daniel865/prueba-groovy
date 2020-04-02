package com.ps.demo

import grails.persistence.Entity
import org.grails.datastore.gorm.GormEntity

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User implements GormEntity<User> {

    Long id
    String name
    Integer document

    static constraints = {
        name nullable: false
        document nullable: false
    }

    static mapping = {
        id column:  'id_usuario'
        name column: 'nombre'
        document column: 'documento'
    }

}
