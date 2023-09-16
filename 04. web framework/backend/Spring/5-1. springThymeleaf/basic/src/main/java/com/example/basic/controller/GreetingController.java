package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GreetingController {
  
  @GetMapping("/greeting")
  public String greeting() {

    log.info("greeting");
    return "greeting";
  }
  @GetMapping("/thymeleaf/model-test")
  public String modelTest(@RequestParam(name = "greeting", required=false, defaultValue="Hi") String greeting, Model model) {
    
    log.info("thymeleafGreeting");
    model.addAttribute("greeting", greeting);
    return "thymeleafGreeting";
  }

  @RequestMapping("/utext")
  public String utext(Model model) {
    model.addAttribute("tag","<h2>태그 전달하기</h2>");
    return "thymeleaf/utext";
  }

  @RequestMapping("/pv/{num}")
  public String pv1(Model model, @PathVariable(name = "num") int numtest) {
    model.addAttribute("num", numtest);
    System.out.println("test : " +numtest);
    return "thymeleaf/pv1";
  }

  // Form
  @RequestMapping(value = "/form1", method = RequestMethod.GET)
  public String form1(Model model) {
    return "thymeleaf/form1";
  }

  @RequestMapping(value = "/form1", method = RequestMethod.POST)
  public String form2(Model model, @RequestParam("data1") String data1) {
    model.addAttribute("data1", data1);
    return "thymeleaf/form1";
  }

  @RequestMapping("/thymeleaf/mv-test")
  public ModelAndView modelAndViewTest(ModelAndView modelAndView) { // Model(Data) + View 지정

    // (1) 데이터 지정
    // (2) 뷰페이지 지정
    // (3) return
    modelAndView.addObject("name", "이순신");
    modelAndView.addObject("age", 29);
    modelAndView.setViewName("thymeleaf/mv-test");
    return modelAndView;
  }

  @RequestMapping("/pv-mav/{num}")
  public ModelAndView pv1mav(ModelAndView mav, @PathVariable(name = "num") int numtest) {
    mav.addObject("num", numtest);
    mav.setViewName("thymeleaf/pv1");
    System.out.println("test : " +numtest);
    return mav;
  }

  @RequestMapping(value = "/multi1", method = RequestMethod.GET)
  public ModelAndView multiFormPage(ModelAndView mav) {
    mav.addObject("msg", "여러 개 input 값 입력 후 전송 버튼 클릭!");
    mav.setViewName("thymeleaf/multi1");
    return mav;
  }

  @RequestMapping(value ="/multi1", method = RequestMethod.POST)
  public ModelAndView multiFormSend(
      @RequestParam("id") String id,
      @RequestParam("name") String name,
      @RequestParam("email") String email,
      @RequestParam("age") Integer age,
      @RequestParam("gender") String gender,
      ModelAndView mav) {

    mav.addObject("id", id);
    mav.addObject("name", name);
    mav.addObject("email", email);
    mav.addObject("age", age);
    mav.addObject("gender", gender);
    mav.setViewName("thymeleaf/multi1");
    return mav;
  }

  // dto get
  @RequestMapping(value = "/multi-dto", method = RequestMethod.GET)
  public ModelAndView multiFormPage2(
      @ModelAttribute("formData") UserDto userDto,
      ModelAndView mav) {

    mav.addObject("msg","get req");
    mav.addObject("formData", userDto);
    mav.setViewName("thymeleaf/multi-dto");
    return mav;
  }

  // dto post
  @RequestMapping(value = "/multi-dto", method = RequestMethod.POST)
  public ModelAndView multiFormDtoSend(
      @ModelAttribute("formData") UserDto userDto,
      ModelAndView mav) {

    mav.addObject("formData", userDto);
    mav.setViewName("thymeleaf/multi-dto");
    return mav;
  }

  // Thymeleaf strings util methods
  @RequestMapping(value = "/string-util", method = RequestMethod.GET)
  public ModelAndView viewStringUtil(ModelAndView mav) {

    mav.addObject("msg", "Hello world");
    mav.setViewName("thymeleaf/string-util");
    return mav;
  }

  @RequestMapping(value = "/th-block", method = RequestMethod.GET)
  public ModelAndView viewThBlock(ModelAndView mav) {
    
    mav.addObject("account","비회원");
    mav.setViewName("thymeleaf/th-block");
    return mav;
  }

  // CheckBox
  @RequestMapping(value = "/checkbox", method = RequestMethod.GET)
  public ModelAndView viewCheckBox(ModelAndView mav) {

    mav.setViewName("thymeleaf/checkbox");
    return mav;
  }

  @RequestMapping(value = "checkbox", method = RequestMethod.POST)
  public ModelAndView postCheckBox(
      @RequestParam(value = "food", required = false) List<String> foodList,
      ModelAndView mav) {
          
    mav.addObject("foodList", foodList);
    mav.setViewName("thymeleaf/checkbox");
    return mav;
  }

}
