package hello.servlet;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.annotation.WebServlet;


/**
 *  lombock 접근법
 *
 *  단축키
 *      command + N
 * **/

@Getter
@Setter
public class Lombock {

    private String username;
    private int age;

}
