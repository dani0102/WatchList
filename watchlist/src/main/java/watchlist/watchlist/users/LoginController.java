package watchlist.watchlist.users;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds REST endpoints targeted towards Login and Register-Functionalities.
 * 
 * @author Belinda Schühle
 *
 */
@Controller
@Api(
		value = "LoginController"
	)
public class LoginController {

	private UserServiceable service;
	
	
	/**
	 * @param service
	 */
	@Autowired
	public LoginController(UserServiceable service) {
		super();
		this.service = service;
	}
	
	
	/**
	 * This method returns the login-view
	 *
	 * @return modelAndView with all login-related content
	 */
	@ApiOperation(
		value = "This endpoint returns the login-view"
	)
	@GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


	/**
	 * This method returns the register-view
	 *
	 * @return modelAndView with all register-related content
	 */
	@ApiOperation(
		value = "This endpoint returns the register-view"
	)
	@GetMapping("/register")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

	/**
	 * This method registers/creates a new user
	 * 
	 * @param user
	 * @param bindingResult
	 * @return modelAndView with all register-related content
	 */
	@ApiOperation(
		value = "This endpoint registers/creates a new user"
	)
	@PostMapping("/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = service.findByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.users",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            service.createUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");

        }
        return modelAndView;
    }
	 
}
