package stricto_grails_tarefa

import org.grails.databinding.BindingFormat

class Task {

	String task
	@BindingFormat('yyyy-MM-dd')
	Date requiredBy
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

	public Date getRequiredBy() {
		return requiredBy;
	}

	public void setRequiredBy(Date requiredBy) {
		this.requiredBy = requiredBy
	}
}
