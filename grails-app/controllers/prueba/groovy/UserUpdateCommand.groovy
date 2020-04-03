package prueba.groovy

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class UserUpdateCommand implements Validateable {

    Long id
    Long version
    String name
    Integer document

    static constraints = {
        id nullable: false, blank: false
        version nullable: true, blank: true
        name nullable: false, blank: false
        document nullable: false, blank: false
    }

}
