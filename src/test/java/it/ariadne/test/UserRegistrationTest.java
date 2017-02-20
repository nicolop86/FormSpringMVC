package it.ariadne.test;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import it.ariadne.controller.UserController;
import it.ariadne.model.User;
import it.ariadne.model.UserRepository;

public class UserRegistrationTest {


	@Test

	public void shouldProcessRegistration() throws Exception {
		
		UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

		User unsaved = new User("nick", "manofredda", "nick", "nick");
		User saved = new User(0L, "nick", "manofredda", "nick", "nick");

		/*Mockito allows to define the behavior of the save method
		 * which is not yet implemented*/
		Mockito.when(mockUserRepository.saveUser(unsaved))
		.thenReturn(saved);

		UserController userContr = new UserController(mockUserRepository);

		MockMvc mockMvc = standaloneSetup(userContr).build();

			mockMvc.perform(post("/user/register")
					.param("firstname", "nick")
					.param("lastname", "manofredda")
					.param("username", "nick")
					.param("password", "nick"))
			.andExpect(redirectedUrl("/user/nick"));
			
			Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).saveUser(unsaved);
	}
}
