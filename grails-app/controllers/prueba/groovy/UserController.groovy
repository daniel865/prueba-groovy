package prueba.groovy

import com.ps.demo.CRUD
import com.ps.demo.CrudMessageService
import com.ps.demo.User
import com.ps.demo.UserDataService
import groovy.transform.CompileStatic

import grails.gorm.transactions.Transactional
import org.springframework.context.HierarchicalMessageSource

@SuppressWarnings('LineLength')
@CompileStatic
@Transactional
class UserController {

    static allowedMethods = [
            save: 'POST',
            update: 'PUT',
            show: 'GET',
            delete: 'DELETE',
    ]

    UserDataService userDataService

    HierarchicalMessageSource messageSource

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
                hotelList: userDataService.list(params),
                hotelCount: userDataService.count(),
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
