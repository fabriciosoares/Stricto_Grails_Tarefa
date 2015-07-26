package stricto_grails_tarefa

class Task {

	String task
	Date requiredBy
	String category
	Boolean complete = false

	static constraints = {
	}
}
