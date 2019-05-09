package watchlist.watchlist.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds REST endpoints targeted towards the entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "UserController"
	)
public class UserController {

	private UserServiceable service;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public UserController(UserServiceable service) {
		super();
		this.service = service;
	}
	
	/**
	 * This method returns all Users
	 *
	 * @return ResponseEntity with all existing Users
	 */
	@ApiOperation(
		value = "This endpoint returns all Users",
		response = User.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<User>> getAll() {
		List<User> users = this.service.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested User
	 *
	 * @param  id Id of the requested User
	 * @return    ResponseEntity with the User that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested User",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<User> getById(@PathVariable Long id) {
		User user = this.service.findById(id);
				return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * This method creates a User
	 *
	 * @return ResponseEntity with the User that was created
	 */
	@ApiOperation(
		value = "This endpoint creates a User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The User to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
		this.service.createUser(user);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested User
	 *
	 * @param  id   Id of the User that should get updated
	 * @param  User user entity to which the requested User should get updated to
	 * @return      ResponseEntity with the updated User
	 */
	@ApiOperation(
		value = "This endpoint updates the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The User to be updated",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
		this.service.updateUser(id, user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested User
	 *
	 * @param  id Id of the User that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested User",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var user = this.service.findById(id);
		this.service.deleteUser(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


	@GetMapping("/register")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

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

	@GetMapping("/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = service.findByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
	
	
}
