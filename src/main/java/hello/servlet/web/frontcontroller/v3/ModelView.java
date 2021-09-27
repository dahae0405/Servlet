package hello.servlet.web.frontcontroller.v3;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Data
public class ModelView {

    private String viewName;
    private Map<String, Object> model;

    public ModelView(String viewName){
        this.viewName = viewName;
    }

}
