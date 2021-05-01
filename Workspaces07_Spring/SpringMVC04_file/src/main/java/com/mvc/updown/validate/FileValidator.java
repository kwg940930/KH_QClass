package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {
	//Validator는 유효성 검사를 위해 사용한다. 프론트엔드(자바스크립트)에서도 할수 있지만 보안을 위해 백엔드에서 하는것이 안전하다.

	@Override
	public boolean supports(Class<?> clazz) {
		// validator 사용 가능 여부 확인
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target;
		
		//파일이 넘어오지 않았을때
		if(file.getMpfile().getSize() == 0) {
			// mpfile(field)에 대한 errorCode return. 해당 errorCode가 없으면 default message 전달
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
	}

}
