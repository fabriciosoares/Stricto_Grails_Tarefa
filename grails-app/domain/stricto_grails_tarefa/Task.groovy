package stricto_grails_tarefa

class Task {

	String task
	String requiredBy
	String category
	Boolean complete = false

	static constraints = {
	}
	
	def list(){
		
	}
	
	def count() {
		
	}
}
