package com.example.basic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
  private long bookid;
  private Boolean isbn;
  private String bookTitle;
  private String author;
  private Double price;
}
