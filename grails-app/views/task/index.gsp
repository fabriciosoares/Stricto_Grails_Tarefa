
<%@ page import="stricto_grails_tarefa.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-task" class="content scaffold-list" role="main">
			<h1>Lista de Tarefas</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:form url="[action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Salvar Tarefa" />
					<g:submitButton name="clean" class="clean" value="Limpar Tarefa" />
				</fieldset>
			</g:form>
			
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="task" title="${message(code: 'task.task.label', default: 'Nome')}" />
						<g:sortableColumn property="requiredBy" title="${message(code: 'task.requiredBy.label', default: 'Dead Line')}" />
						<g:sortableColumn property="category" title="${message(code: 'task.category.label', default: 'Categoria')}" />
						<td>Ações</td>
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${taskInstanceList}" status="i" var="taskInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: taskInstance, field: "task")}</td>
						
						<td><g:formatDate date="${taskInstance.requiredBy}" /></td>
						
						<td>${fieldValue(bean: taskInstance, field: "category")}</td>
						
						<td>
							<g:link class="edit" action="edit" resource="${taskInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
							<g:link class="complete" action="complete">Completar</g:link>
							<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create">Adicionar Tarefa</g:link></li>
			</ul>
		</div>
		<div class="pagination">
			Você tem <g:paginate total="${taskInstanceCount ?: 0}" /> tarefas
		</div>
	</body>
</html>
