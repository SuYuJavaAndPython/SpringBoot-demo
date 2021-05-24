import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Grab("org.springframework.boot:spring-boot-starter-thymeleaf:2.4.5")
@Grab("org.webjars:jquery:3.6.0")
@Controller
class HelloCli {

    @RequestMapping("/")
    String home(Model model){
        model.addAttribute("name","welcome")
        return "welcome"
    }
}
