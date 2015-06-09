class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/test"(view:"/test/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
