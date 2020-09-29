package com.objectcomputing

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.inject.Inject

@Controller("/groovyMessage")
class MessageController implements DemoControllerTrait {

    @Inject MessageHelper messageHelper

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String message() {
        messageHelper.createMessage()
    }
}
