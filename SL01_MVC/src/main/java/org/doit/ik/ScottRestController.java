package org.doit.ik;


import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Ajax 요청을 처리하는 컨트롤러
@RestController
public class ScottRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ScottRestController.class);
	
	@Autowired
	private DeptMapper deptMapper;
	
	// json -> DeptDTO 
	@PostMapping("/scott/dept/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){
		logger.info(">");
		int rowCount = this.deptMapper.insertDept(dto);
		
		return rowCount==1
				? new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	@GetMapping("/scott/dept/delete")
	public ResponseEntity<String> deleteDept(@RequestParam("deptno") int deptno){  // 하나면 @RequestParam("deptno") 생략가능
		logger.info("> ScottRestController.insertDept()...");

		int rowCount = this.deptMapper.deleteDept(deptno);
		
		return rowCount==1
				? new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/
	@DeleteMapping("/scott/dept/{deptno}")
	public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno){  // 하나면 @RequestParam("deptno") 생략가능
		logger.info("> ScottRestController.insertDept()...");

		int rowCount = this.deptMapper.deleteDept(deptno);
		
		return rowCount==1
				? new ResponseEntity<String>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
