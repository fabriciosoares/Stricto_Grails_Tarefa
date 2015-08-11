package stricto_grails_tarefa

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskController {

//	static allowedMethods = [save: "POST", update: "PUT", delete:['POST', 'DELETE']]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
	//	params.sort(taskInstance.requiredBy)
		respond Task.list(params) //, sort: "taskInstance.requiredBy", order: "desc") //, model:[taskInstanceCount: Task.count()]
	}

	def create(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Task.list(params), view: 'edit'
	}

	def edit(Task taskInstance, Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond taskInstance
		respond Task.list(params), view: 'edit'
	}

	@Transactional
	def complete(Task taskInstance) {
		if (taskInstance == null) {
			notFound()
			return
		}
		if (taskInstance.hasErrors()) {
			respond taskInstance.errors, view:'index'
		}
		
		taskInstance.setComplete(true);
		
		taskInstance.save flush:true
		redirect action: "index", method: "GET"
	}

	@Transactional
	def save(Task taskInstance) {
		if (taskInstance == null) {
			notFound()
			return
		}
		if (taskInstance.hasErrors()) {
			respond taskInstance.errors, view:'index'
			return
		}
	//	taskInstance.setRequiredBy(Date().parse("yyyy-MM-dd", taskInstance.requiredBy))
		taskInstance.save flush:true
		redirect action: "index", method: "GET"
	}

	@Transactional
	def delete(Task taskInstance) {
		if (taskInstance == null) {
			notFound()
			return
		}
		taskInstance.delete flush:true
		redirect action: "index", method: "GET"
//		request.withFormat {
//			form multipartForm {
//				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Task.label', default: 'Task'), taskInstance.id])
//				redirect action:"index", method:"GET"
//			}
//			'*'{ render status: NO_CONTENT }
//		}
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
