package prueba.groovy

class UrlMappings {

    static mappings = {
        '/'(controller: 'user', action:'index')
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}
