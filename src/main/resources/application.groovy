micronaut {
  security {
    enabled = true
    basicAuth {
        enabled = false
    }
    authentication = "bearer"
    endpoints {
        login {
            enabled = true
            path = "/api/authenticate"
        }
        logout {
            enabled = true
            path = "/api/logout"
        }
    }
    interceptUrlMap = [
        [pattern: "/",                  access: "isAnonymous()"],
        [pattern: "/message",           access: "isAnonymous()"],
        [pattern: "/groovyMessage",     access: "isAnonymous()"],
        [pattern: "/groovyMessage/**",  access: "isAnonymous()"]
    ]
  }
}
