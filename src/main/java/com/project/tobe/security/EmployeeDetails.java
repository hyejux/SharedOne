package com.project.tobe.security;

import com.project.tobe.dto.AuthorityDto;
import com.project.tobe.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeDetails implements UserDetails {

  private Employee employee;

  public EmployeeDetails(Employee employee) {
    this.employee = employee;
  }

  // 권한 관련 작업을 하기 위한 role return
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collections = new ArrayList<>();
    collections.add(() -> {
      return employee.getEmployeeName();
    });

    return collections;
  }

  // get Password 메서드
  @Override
  public String getPassword() {
    return employee.getEmployeePw();
  }

  // get Username 메서드 (생성한 User은 loginId 사용)
  @Override
  public String getUsername() {
    return employee.getEmployeeId();
  }


  public String getNickname() {
    System.out.println(employee.toString());
    System.out.println(employee.getEmployeeName());
    return employee.getEmployeeName();
  }


  public String getUserAuthorityGrade() {
    return employee.getAuthorityGrade();
  }

//  public String getUserAuthorityName() {
//    System.out.println(authorityDto.toString());
//    System.out.println(authorityDto.getEmployeeName());
//    return authorityDto.getAuthorityName();
//  }


  // 계정이 만료 되었는지 (true: 만료X)
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // 계정이 잠겼는지 (true: 잠기지 않음)
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 비밀번호가 만료되었는지 (true: 만료X)
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // 계정이 활성화(사용가능)인지 (true: 활성화)
  @Override
  public boolean isEnabled() {
    return true;
  }
}
