package org.parboiled.examples.sql

import org.parboiled.scala._

class SqlParser extends Parser {
  def SelectQuery = rule { WhiteSpace ~ SELECT ~ SelectList ~ optional(FROM ~ TableReference) }

  def SelectList = rule { "*" ~ WhiteSpace }

  def TableReference = { TableName ~ WhiteSpace }

  def TableName = rule { Identifier }

  def Identifier = rule { Character ~ oneOrMore(Digit | Character) }

  def Character = rule { "a" - "z" | "A" - "Z" }

  def Digit = rule { "0" - "9" }

  def SELECT = rule { ignoreCase("SELECT") ~ WhiteSpace }

  def FROM = rule { ignoreCase("FROM") ~ WhiteSpace }

  def WhiteSpace = rule { zeroOrMore(anyOf(" \n\r\t\f")) }
}