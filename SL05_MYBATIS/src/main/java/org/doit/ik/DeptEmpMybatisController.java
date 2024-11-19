package org.doit.ik;

import org.doit.ik.domain.DeptEmpSalgradeDTO;
import org.doit.ik.mapper.DeptEmpSalgradeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class DeptEmpMybatisController {
	
	//private static final Logger logger = LoggerFactory.getLogger(DeptEmpMybatisController.class);

	//@Autowired
	private DeptEmpSalgradeMapper deptEmpSalgradeMapper;
	
	@GetMapping(value= "/dept/emp")
	public void getDeptEmpSalgrade(Model model, DeptEmpSalgradeDTO dto) {
		log.info("> DeptEmpSalgradeMapper.getDeptEmpSalgrade()...");
		deptEmpSalgradeMapper.getDeptEmpInfo();
		model.addAttribute("dto", dto);
	}
	
}
