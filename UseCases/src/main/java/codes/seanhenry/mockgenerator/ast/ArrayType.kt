package codes.seanhenry.mockgenerator.ast

import codes.seanhenry.mockgenerator.visitor.Visitor

class ArrayType(text: String, val type: Type): Type(text) {

  override fun accept(visitor: Visitor) {
    visitor.visitArrayType(this)
  }

  class Builder {

    private var type = Type.EMPTY

    fun type(type: String): Builder {
      this.type = Type(type)
      return this
    }

    fun build(): ArrayType {
      return ArrayType("[${type.text}]", type)
    }
  }
}