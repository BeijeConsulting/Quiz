package restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestController {
	
	public static final String PATH = "C:\\Users\\Padawan09\\git\\CilacapWeb\\src\\it\\beije\\cilacap\\Rubrica.xml";

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public @ResponseBody {
	
	}