package com.github.zkejid.springdemo.service;

import com.github.zkejid.springdemo.entities.TextEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextEntityRepositoryTest {
    @Autowired
    private TextEntityRepository textEntityRepository;

    @Before
    public void setUp() throws Exception {
        //TODO Panfilov I.V. 10.08.17: avoid influence between test calls
        // without delete all there is bootstrap data visible:
        // com.github.zkejid.springdemo.SpringDemoApplication.bootstrap()
        textEntityRepository.deleteAll();
        textEntityRepository.save(new TextEntity("John Doe", "SEO", new Date()));
        textEntityRepository.save(new TextEntity("John Doe", "Senior", new Date()));
        textEntityRepository.save(new TextEntity("Jillian Doe", "Middle", new Date()));
        textEntityRepository.save(new TextEntity("John Smith", "Junior", new Date()));
    }

    @Test
    public void test(){}

    @After
    public void tearDown() throws Exception {
        textEntityRepository.deleteAll();
    }
}