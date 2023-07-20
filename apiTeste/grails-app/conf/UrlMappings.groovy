class UrlMappings {

	static mappings = {
        "/api/produtos"(resources: "produto")
/*        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
