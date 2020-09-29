package com.objectcomputing.web.rest;

import com.objectcomputing.MessageHelper;
import io.micronaut.context.env.Environment;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.types.files.StreamedFile;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import java.util.Optional;

@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
public class ClientForwardController {

    private final MessageHelper messageHelper;

    private final Environment environment;

    public ClientForwardController(MessageHelper messageHelper, Environment environment) {
        this.messageHelper = messageHelper;
        this.environment = environment;
    }

    /**
     * Forwards any unmapped paths (except those containing a period) to the client {@code index.html}.
     * @return forward to client {@code index.html}.
     */
    @Get("/{path:[^\\.]*}")
    public Optional<StreamedFile> forward(String path) {
        return environment.getResource("classpath:static/index.html")
            .map(StreamedFile::new);
    }

    @Get("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return messageHelper.createMessage();
    }
}
