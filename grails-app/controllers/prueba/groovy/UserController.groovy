package prueba.groovy

import com.ps.demo.CRUD
import com.ps.demo.CrudMessageService
import com.ps.demo.User
import com.ps.demo.UserDataService
import groovy.transform.CompileStatic

import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource

@SuppressWarnings('LineLength')
@CompileStatic
@Transactional
class UserController {

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

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [
                userList: userDataService.list(params),
                userCount: userDataService.count(),
        ]
    }

    def show(Long id) {
        User user = userDataService.get(id)
        if (!user) {
            notFound()
            return
        }
        [user: user]
    }

    @SuppressWarnings(['FactoryMethodName'])
    def create() {
        [user: new User()]
    }

    def edit(Long id) {
        User user = userDataService.get(id)
        if (!user) {
            notFound()
            return
        }
        [user: user]
    }

    def save(UserCreateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [user: cmd], view:'create'
            return
        }

        User user = userDataService.save(new User(cmd.id, cmd.name, cmd.document))

        if ( user == null ) {
            notFound()
            return
        }

        if ( user.hasErrors() ) {
            respond user.errors, model: [user: user], view:'create'
            return
        }

        Locale locale = request.locale
        flash.message = crudMessageService.message(CRUD.CREATE, domainName(locale), user.id, locale)
        redirect user
    }

    def update(UserUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [user: cmd], view: 'edit'
            return
        }

        User user = userDataService.update(cmd.id, cmd.version, cmd.name, cmd.document)

        if ( user == null) {
            notFound()
            return
        }

        if ( user.hasErrors() ) {
            respond user.errors, model: [user: user], view: 'edit'
            return
        }

        Locale locale = request.locale
        flash.message = crudMessageService.message(CRUD.UPDATE, domainName(locale), user.id, locale)
        redirect user
    }

    def delete(Long id) {

        if (!id) {
            notFound()
            return
        }

        userDataService.delete(id)

        Locale locale = request.locale
        flash.message = crudMessageService.message(CRUD.DELETE, domainName(locale), id, locale)
        redirect action: 'index', method: 'GET'
    }

    protected void notFound() {
        Locale locale = request.locale
        flash.message = crudMessageService.message(CRUD.DELETE, domainName(locale), params.long('id'), locale)
        redirect action: 'index', method: 'GET'
    }

}
