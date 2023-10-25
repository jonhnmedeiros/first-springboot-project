package dev.jonathanmedeiros.ioc_di;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/component")
public class MyControllerComponent {
    
    @Autowired
    MyComponent myComponent;
    
    @GetMapping(value="/")
    public String callComponent(){
        var result = myComponent.callMyComponent();
        return result;
    }
    
}
