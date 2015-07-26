<%@ page import="stricto_grails_tarefa.Task" %>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'task', 'error')} required">
	<label for="task">
		<g:message code="task.task.label" default="Task" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="task" required="" value="${taskInstance?.task}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'requiredBy', 'error')} required">
	<label for="requiredBy">
		<g:message code="task.requiredBy.label" default="Required By" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="requiredBy" precision="day"  value="${taskInstance?.requiredBy}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="task.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	

	<g:select id="category" name="category" value="${taskInstance?.category}"
		from="${['Pessoal': 'Pessoal', 'Profissional': 'Profissional']}"
		optionKey="key" optionValue="value"
		required="" noSelection="['null':'Selecione uma Categoria']" />

</div>