package com.github.zkejid.springdemo.web;

import com.github.zkejid.springdemo.entities.TextEntity;
import com.github.zkejid.springdemo.service.TextEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Controller defines web access to application.
 */
@RestController
public class ApplicationController {

    @Autowired
    private TextEntityRepository textEntityRepository;

    /**
     * Index page handler.
     * <p/>
     * Returns description of application service.
     */
    @RequestMapping("/")
    public String index() {
        return "TextEntity CRUD application";
    }

    /**
     * TextEntity creation handler.
     * <p/>
     * Places new instance with given attribute values into DB.
     * <p/>
     * TODO Panfilov I.V. 10.08.17: test it. check corner cases of arguments.
     * @param title {@link TextEntity#title}
     * @param content {@link TextEntity#content}
     * @return newly created and persisted instance of TextEntity
     */
    @RequestMapping("/text/create")
    public TextEntity create(
            @RequestParam(value="title") String title,
            @RequestParam(value="content") String content
    ) {
        return textEntityRepository.save(new TextEntity(title, content, new Date()));
    }

    /**
     * TextEntity list handler.
     * TODO Panfilov I.V. 10.08.17: test it.
     * TODO Panfilov I.V. 10.08.17: avoid OOME on large dataset. add restrictions
     * @return list of all text entity instances
     */
    @RequestMapping("/text/list")
    public Iterable<TextEntity> list() {
        return textEntityRepository.findAll();
    }
}