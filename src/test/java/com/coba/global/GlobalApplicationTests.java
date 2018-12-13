package com.coba.global;

import com.coba.global.entities.Task;
import com.coba.global.entities.User;
import com.coba.global.services.TaskService;
import com.coba.global.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testuser@mail.com", "testuser", "12345");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("admin@mail.com", "admin", "12345");
            userService.createAdmin(newUser);
        }

        Task userTask = new Task("03/10/2018", "00:11", "11:00", "You need to work today");
        User user = userService.findOne("testUser@mail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
        User user = userService.findOne("testuser@mail.com");
        assertNotNull(user);
        User admin = userService.findOne("testadmin@mail.com");
        assertEquals(admin.getEmail(), "testadmin@mail.com");
    }

    @Test
    public void testTask() {
        User user = userService.findOne("testuser@mail.com");
        List<Task> tasks = taskService.findUserTask(user);
        assertNotNull(tasks);
    }

}
