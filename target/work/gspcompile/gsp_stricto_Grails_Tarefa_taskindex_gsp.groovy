import stricto_grails_tarefa.Task
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_stricto_Grails_Tarefa_taskindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/task/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
loop:{
int i = 0
for( taskInstance in (taskInstanceList) ) {
printHtmlPart(9)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(10)
expressionOut.print(fieldValue(bean: taskInstance, field: "task"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: taskInstance, field: "requiredBy"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: taskInstance, field: "category"))
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',40,['class':("edit"),'action':("edit"),'resource':(taskInstance)],3)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',41,['class':("complete"),'action':("complete"),'resource':(taskInstance)],3)
printHtmlPart(14)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',42,['class':("delete"),'action':("delete"),'resource':(taskInstance)],3)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',51,['class':("create"),'action':("create")],2)
printHtmlPart(20)
invokeTag('paginate','g',58,['total':(taskInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1439189310000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
