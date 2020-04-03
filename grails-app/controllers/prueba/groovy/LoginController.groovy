package prueba.groovy

import com.ps.demo.CRUD
import com.ps.demo.CrudMessageService
import com.ps.demo.User
import com.ps.demo.UserDataService
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.springframework.context.MessageSource

@SuppressWarnings('LineLength')
@CompileStatic
@Transactional
class LoginController {

    static allowedMethods = [
            save: 'POST',
            update: 'PUT',
            show: 'GET',
            delete: 'DELETE',
            get: 'GET'
    ]

    UserDataService userDataService

    MessageSource messageSource

    CrudMessageService crudMessageService

    private String domainName(Locale locale) {
        messageSource.getMessage('user.label',
                [] as Object[],
                'User',
                locale)
    }

    def index() {
        [user: new User()]
    }

    @SuppressWarnings(['FactoryMethodName'])
    def create() {
        [user: new User()]
    }

    def login(String name, Integer document) {
        User user = userDataService.get(name, document)
        if (!user) {
            notFound()
            return
        }
        [user: user]
    }

    protected void notFound() {
        Locale locale = request.locale
        flash.message = crudMessageService.message(CRUD.DELETE, domainName(locale), params.long('id'), locale)
        redirect action: 'index', method: 'GET'
    }



}
