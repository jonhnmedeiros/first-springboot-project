package dev.jonathanmedeiros.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MyComponent {
    public String callMyComponent(){
        return "Calling my component";
    }
    
}
