package com.objectcomputing

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

trait DemoControllerTrait {

    @Get("/trait")
    @Produces(MediaType.TEXT_PLAIN)
    String traitMessage() {
        "Hello from a Groovy Trait!"
    }

}
