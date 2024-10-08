package com.project.tobe.controller;

import com.project.tobe.dto.AuthorityDto;
import com.project.tobe.security.EmployeeDetails;
import com.project.tobe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mypage")
public class MypageController {

  @Autowired
  @Qualifier("employeeService")
  private EmployeeService employeeService;

  @PostMapping("/mypageAll")
  public AuthorityDto mypageAll(@RequestParam String employeeId){
    System.out.println("마이페이지 컨트롤러" + employeeId);
    System.out.println(employeeService.mypageAll(employeeId));
    return employeeService.mypageAll(employeeId);
  }

  @GetMapping("/mypageSession")
  public String mypageSession(Authentication authentication){
    String userId = "";

    if(authentication != null) { //인증이 되지않았다면 null입니다.
      EmployeeDetails user = (EmployeeDetails)authentication.getPrincipal(); //인증객체 안에 principal값을 얻으면 유저객체가 나옵니다.
      userId = user.getUsername();
      System.out.println(userId);
    }

    return userId;

  }



}
