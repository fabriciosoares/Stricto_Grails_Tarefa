<%@ page import="stricto_grails_tarefa.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Tarefas</title>
		<link rel="stylesheet" type="text/css" href="/Stricto_Grails_Tarefa/assets/02-tasks.css" media="screen" />
	</head>
	<body>
		<header>
			<span>Lista de Tarefas</span>
		</header>
		<main id="taskPage">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<section id="taskCreation"> <!-- class="not"> -->
				<g:form url="[resource:taskInstance, action:'save']" id="taskForm">
					<g:hiddenField name="version" value="${taskInstance?.version}" />
					<fieldset class="form">
						<g:render template="form"/>
					</fieldset> 
					<nav>
						<g:submitButton id="saveTask" name="create" class="save" value="Salvar Tarefa" />
						<g:submitButton name="clean" class="clean" value="Limpar Tarefa" />
					</nav>
				</g:form>
			</section>
			
			<table>
				<colgroup>
					<col width="40%">
					<col width="15%">
					<col width="15%">
					<col width="30%">
				</colgroup>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Deadline</th>
						<th>Categoria</th>
						<th>Ações</th>
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
		</main>
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
