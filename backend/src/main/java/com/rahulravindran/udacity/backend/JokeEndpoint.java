/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.rahulravindran.udacity.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;
import com.rahulravindran.udacity.JokesLibrary;

/** An endpoint class we are exposing */
@Api(
  name = "libjoke",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.udacity.rahulravindran.com",
    ownerName = "backend.udacity.rahulravindran.com",
    packagePath=""
  )
)
public class JokeEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getRandomJoke")
    public Joke getRandomJoke() {
        return new Joke(JokesLibrary.getRandomJoke());
    }

}
