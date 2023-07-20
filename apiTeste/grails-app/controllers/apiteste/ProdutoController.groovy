package apiteste

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProdutoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        // Ação para listar todos os produtos
        def produtos = Produto.list()
        render produtos as JSON
    }

    def show(Long id) {
        // Ação para mostrar os detalhes de um produto específico
        def produto = Produto.get(id)
        if (!produto) {
            // Se o produto não for encontrado, retornar um erro 404
            notFound()
            return
        }
        render produto as JSON
    }

    def create() {
        // Ação para criar um novo produto a partir dos dados enviados na requisição
        def produto = new Produto(params)
        if (!produto.save()) {
            // Se ocorrer um erro na validação ou persistência, retornar um erro 400
            response.status = 400
            render produto.errors as JSON
            return
        }
        render produto as JSON
    }

    def update(Long id) {
        // Ação para atualizar um produto existente a partir dos dados enviados na requisição
        def produto = Produto.get(id)
        if (!produto) {
            // Se o produto não for encontrado, retornar um erro 404
            notFound()
            return
        }
        produto.properties = params
        if (!produto.save()) {
            // Se ocorrer um erro na validação ou persistência, retornar um erro 400
            response.status = 400
            render produto.errors as JSON
            return
        }
        render produto as JSON
    }

    def delete(Long id) {
        // Ação para deletar um produto existente
        def produto = Produto.get(id)
        if (!produto) {
            // Se o produto não for encontrado, retornar um erro 404
            notFound()
            return
        }
        produto.delete()
        render status: 204
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
