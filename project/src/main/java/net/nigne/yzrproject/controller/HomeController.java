package net.nigne.yzrproject.controller;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.nigne.yzrproject.domain.EmpVO;
import net.nigne.yzrproject.service.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	private EmpService service;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		service.empInsert(29);

		List<EmpVO> list=service.getList();
		
		model.addAttribute("list", list);
		
		return "home";
	}
	
}