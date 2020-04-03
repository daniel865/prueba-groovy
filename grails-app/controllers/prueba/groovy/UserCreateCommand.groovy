package prueba.groovy

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class UserCreateCommand implements Validateable {

    Long id
    String name
    Integer document

    static constraints = {
        id nullable: true, blank: true
        name nullable: false, blank: false
        document nullable: false, blank: false
    }

}
