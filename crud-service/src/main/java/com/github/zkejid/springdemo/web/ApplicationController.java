package com.github.zkejid.springdemo.web;

import com.github.zkejid.springdemo.entities.TextEntity;
import com.github.zkejid.springdemo.entities.TextEntityCreateResponse;
import com.github.zkejid.springdemo.service.TextEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Controller defines web access to application.
 */
@RestController
public class ApplicationController {

    @SuppressWarnings("unused") //cause autowired
    @Autowired
    private TextEntityRepository textEntityRepository;

    /**
     * TextEntity creation handler.
     * <p/>
     * Places new instance into the system.
     * <p/>
     * @param textEntity binding for object to save. not fully valid - need {@link TextEntity#creationDate}.
     * @return newly created and persisted instance of TextEntity
     */
    @SuppressWarnings("WeakerAccess")   // Cause it is rest handler.
    // TODO Panfilov I.V. Move /create to "path constants" class
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    // There is no @Valid on textEntity cause it is not valid yet.
    // TODO Panfilov I.V. rework validation so it would be possible to validate argument other way than if-conditions.
    public TextEntityCreateResponse create(TextEntity textEntity) {
        if (textEntity.getId() != null) {
            assert false : "id should be null";
            return new TextEntityCreateResponse("id should be null");
        }
        // TODO Panfilov I.V. Have to use magic constant. Better to use custom validators
        if (textEntity.getTitle() == null || textEntity.getTitle().length() > 160) {
            assert false : "title should not be null and should be less than 160";
            return new TextEntityCreateResponse("title should not be null and should be less than 160");
        }
        if (textEntity.getContent() == null) {
            assert false : "content should not be null";
            return new TextEntityCreateResponse("content should not be null");
        }
        if (textEntity.getCreationDate() != null) {
            assert false : "creation date should be null";
            return new TextEntityCreateResponse("creation date should be null");
        }
        textEntity.setCreationDate(new Date());
        TextEntity save = textEntityRepository.save(textEntity);
        return new TextEntityCreateResponse(save);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "Hello World";
    }
}