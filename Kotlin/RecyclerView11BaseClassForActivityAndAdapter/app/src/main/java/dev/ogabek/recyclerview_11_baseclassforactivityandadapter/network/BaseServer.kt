package dev.ogabek.recyclerview_11_baseclassforactivityandadapter.network

interface BaseServer {
    companion object {
        val IS_TESTER = false
        val SERVER_DEVELOPMENT = "dev.ogabek.dev"
        val SERVER_DEPLOYMENT = "www.ogabek.dev"
    }
}