package com.ps.demo

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def serviceMethod() {

    }

    def get(id){
        User.get(id)
    }

    def list() {
        User.list()
    }

    def save(user){
        user.save()
    }

    def delete(id){
        User.get(id).delete()
    }
}
