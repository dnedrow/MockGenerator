package codes.seanhenry.mockgenerator.ast

import codes.seanhenry.mockgenerator.visitor.Visitor

class BracketType(val type: Type): Type("(${type.text})") {

  override fun accept(visitor: Visitor) {
    visitor.visitBracketType(this)
  }
}