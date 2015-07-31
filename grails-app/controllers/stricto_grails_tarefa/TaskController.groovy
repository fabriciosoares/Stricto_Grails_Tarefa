package stricto_grails_tarefa



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Task.list(params), model:[taskInstanceCount: Task.count()]
	}

//	def show(Task taskInstance) {
//		respond taskInstance
//	}

	def create() {
		redirect action: "index", method: "GET" //, find('#taskCreation' ).removeClass('not')  // Foco no campo task
	}

	def edit(Task taskInstance) {
		redirect action: "index", method: "GET" // respond taskInstance // Foco no campo task
	}
	
	def clean() {
		redirect action: "index", method: "GET" // Foco no campo task
	}
	
	def complete(Task taskInstance) {
		redirect action: "index", method: "GET"
	}

	@Transactional
	def save(Task taskInstance) {
		if (taskInstance == null) {
			notFound()
			return
		}
		if (taskInstance.hasErrors()) {
			respond taskInstance.errors, view:'create'
			return
		}
		taskInstance.save flush:true
		redirect action: "index", method: "GET"
	}

//	@Transactional
//	def update(Task taskInstance) {
//		if (taskInstance == null) {
//			notFound()
//			return
//		}
//
//		if (taskInstance.hasErrors()) {
//			respond taskInstance.errors, view:'edit'
//		}
//
//		taskInstance.save flush:true
//
//		request.withFormat {
//			form multipartForm {
//				flash.message = message(code: 'default.updated.message', args: [message(code: 'Task.label', default: 'Task'), taskInstance.id])
//				redirect taskInstance
//			}
//			'*'{ respond taskInstance, [status: OK] }
//		}
//	}

	@Transactional
	def delete(Task taskInstance) {

		if (taskInstance == null) {
			notFound()
			return
		}

		taskInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Task.label', default: 'Task'), taskInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
