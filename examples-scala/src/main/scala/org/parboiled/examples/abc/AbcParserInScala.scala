package org.parboiled.examples.abc

import org.parboiled.scala._

class AbcParserInScala extends Parser {
  def S = rule { &(A ~ "c") ~ oneOrMore("a") ~ B ~ !("a" | "b" | "c") }
  def A: Rule0 = rule { "a" ~ optional(A) ~ "b" }
  def B: Rule0 = rule { "b" ~ optional(B) ~ "c" }
}