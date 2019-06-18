package br.udi.william.demos.distributedtracing.orderweb.application.util

class ContextHolder {
    companion object {
        @JvmStatic
        val contextThreadLocal = InheritableThreadLocal<Context>()

        @JvmStatic
        fun setContext(context: Context) {
            contextThreadLocal.set(context)
        }

        @JvmStatic
        fun getContext(): Context? {
            return contextThreadLocal.get()
        }

        @JvmStatic
        fun resetContext() {
            contextThreadLocal.set(null)
        }
    }
}
