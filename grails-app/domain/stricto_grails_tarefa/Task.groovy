package stricto_grails_tarefa

class Task {

	String task
	String requiredBy
	String category
	Boolean complete = false

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	static constraints = {
	}
	
	def list(){
		
	}
	
	def count() {
		
	}
}
