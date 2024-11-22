package org.doit.ik.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	String getTime();
	
	@Select("Select SYSDATE+1 FROM dual")
	String getNextTime();
	
}
