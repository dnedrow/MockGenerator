package codes.seanhenry.mockgenerator.entities

import codes.seanhenry.mockgenerator.visitor.Visitor

data class Method(val name: String, val genericParameters: List<String>, val returnType: MethodType, val parametersList: List<Parameter>, val declarationText: String, val throws: Boolean): Element {

  override fun accept(visitor: Visitor) {
    visitor.visitMethod(this)
  }

  class Builder(val name: String) {

    private var returnType = MethodType.IMPLICIT
    private var throws = false
    private var parameters = ArrayList<Parameter>()
    private var genericParameters = ArrayList<String>()

    fun build(): Method {
      return Method(name, genericParameters, returnType, parameters, getDeclarationText(), throws)
    }

    fun returnType(type: String): Builder {
      returnType = MethodType.Builder(type).build()
      return this
    }

    fun returnType(): TypeIdentifier.Factory<Builder> {
      return TypeIdentifier.Factory(this) { returnType = MethodType(it, it, it) }
    }

    fun throws(): Builder {
      throws = true
      return this
    }

    fun parameter(name: String, build: (Parameter.Builder) -> Unit): Builder {
      val builder = Parameter.Builder(name)
      build(builder)
      return parameter(builder.build())
    }

    fun parameter(externalName: String, internalName: String, build: (Parameter.Builder) -> Unit): Builder {
      val builder = Parameter.Builder(externalName, internalName)
      build(builder)
      return parameter(builder.build())
    }

    private fun parameter(parameter: Parameter): Builder {
      parameters.add(parameter)
      return this
    }

    fun genericParameter(identifier: String): Builder {
      genericParameters.add(identifier)
      return this
    }

    private fun getDeclarationText(): String {
      var returnString = ""
      var throwString = ""
      val parametersString: String = parameters.map { it.text }.joinToString(", ")
      if (returnType != MethodType.IMPLICIT) {
        returnString = " -> ${returnType.originalType.text}"
      }
      if (throws) {
        throwString = " throws"
      }
      return "func $name${getGenericClauseText()}($parametersString)$throwString$returnString"
    }

    private fun getGenericClauseText(): String {
      if (genericParameters.isEmpty()) {
        return ""
      }
      val list = genericParameters.joinToString(", ")
      return "<$list>"
    }
  }
}