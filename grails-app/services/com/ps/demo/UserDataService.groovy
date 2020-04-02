package com.ps.demo

import grails.gorm.services.Service

@Service(User)
interface UserDataService {

    User get(Long id)
    List<User> list(Map args)
    Number count()
    void delete(Serializable id)
    User save(String name)
    User update(Serializable id, Long version, String name)
    User update(Serializable id, Long version, String name, Integer document)

}
