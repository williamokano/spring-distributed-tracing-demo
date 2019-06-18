package br.udi.william.demos.distributedtracing.orderweb.application.filter

import br.udi.william.demos.distributedtracing.orderweb.application.util.Context
import br.udi.william.demos.distributedtracing.orderweb.application.util.ContextHolder
import org.slf4j.LoggerFactory
import javax.servlet.*
import javax.servlet.http.HttpServletRequest

class ContextFilter : Filter {

    private companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    override fun init(filterConfig: FilterConfig?) {
        logger.debug("Init called")
    }

    override fun doFilter(
        request: ServletRequest?,
        response: ServletResponse?,
        chain: FilterChain?
    ) {
        val httpServletRequest = request as HttpServletRequest
        val organizationSlug: String = httpServletRequest.getHeader("x-organization-slug") ?: "None sent"
        ContextHolder.setContext(Context(organizationSlug))

        chain?.doFilter(request, response)

        ContextHolder.resetContext()
    }

    override fun destroy() {
        logger.debug("Destroy called")
    }
}
