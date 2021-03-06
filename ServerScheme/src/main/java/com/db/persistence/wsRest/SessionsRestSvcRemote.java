package com.db.persistence.wsRest;

import org.springframework.web.bind.annotation.*;

/**
 * Created by taljmars on 4/28/17.
 */
public interface SessionsRestSvcRemote {

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    void publish();

    @RequestMapping(value = "/discard", method = RequestMethod.POST)
    void discard();

}