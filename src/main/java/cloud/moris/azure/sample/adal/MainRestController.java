package cloud.moris.azure.sample.adal;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @Autowired
    private UserService userService;        

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/listusers", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String menu(Principal principal) {
        return userService.listUsers();
    }
}
