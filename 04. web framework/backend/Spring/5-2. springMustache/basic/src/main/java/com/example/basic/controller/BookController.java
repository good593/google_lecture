package com.example.basic.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {

  @GetMapping("/hello")
  public String getHello(Model model) {

    model.addAttribute("name","홍길동");
    model.addAttribute("company","<b>Github</b>");
    model.addAttribute("person",false);
    return "Hello";
  }

  @GetMapping("/book")
  public String getBook(Model model) {
    int i = 1;
    Book book = new Book((long) i,
              false,
              "<title> Book Title </title>",
              "",
              (double) (100 * i));
    
    model.addAttribute("book",book);
    return "book";
  }


  @GetMapping("/bookList")
  public String getBooks(Model model) {
    log.info("books");
    
    List<Book> bookList = new ArrayList<Book>();

    for(int i=0;i<5;i++){
      Book book = new Book((long) i,
              (i <3) ? true : false,
              "Book Name " + i,
              "Author " + i,
              (double) (100 * i));
      bookList.add(book);
    }

    model.addAttribute("bookList",bookList);
    return "bookList";
  }

}
