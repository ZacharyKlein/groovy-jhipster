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
//    interceptUrlMap: [
//        [pattern: "/",                                  access: "isAnonymous()"],
//        [pattern: "/message",                           access: "isAnonymous()"],
//        [pattern: "/manifest.webapp",                   access: "isAnonymous()"],
//        [pattern: "/app/**/*.*",                        access: "isAnonymous()"],
//        [pattern: "/i18n/**",                           access: "isAnonymous()"],
//        [pattern: "/content/**",                        access: "isAnonymous()"],
//        [pattern: "/swagger-ui/index.html",             access: "isAnonymous()"],
//        [pattern: "/favicon.ico",                       access: "isAnonymous()"],
//        [pattern: "/test/**",                           access: "isAnonymous()"],
//        [pattern: "/api/register",                      access: "isAnonymous()"],
//        [pattern: "/api/activate",                      access: "isAnonymous()"],
//        [pattern: "/api/account/reset-password/init",   access: "isAnonymous()"],
//        [pattern: "/api/account/reset-password/finish", access: "isAnonymous()"],
//        [pattern: "/api/**",                            access: "isAuthenticated()"],
//        [pattern: "/management/health",                 access: "isAnonymous()"],
//        [pattern: "/management/info",                   access: "isAnonymous()"],
//        [pattern: "/management/prometheus",             access: "isAnonymous()"],
//        [pattern: "/management/**",                     access: "ROLE_ADMIN"]
//
//    ]
  }
}
