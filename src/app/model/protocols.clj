(ns app.model.protocols)

; In the namespace we define the protocols describing Java elements.
; We will then implement these protocols both using Javaparser ASTs and Javassist elements obtained by 
; loading JAR files.

(defprotocol TypeRef
  "Reference to a type. A TypeRef could be a primitive type or a reference type (enum, class, interface). 
  In the later case it could take type parameters (other TypeRefs). It could also be a TypeVariable, like in:
  
  class A<B> { } 
  
  where B is a TypeVariable. It could also be Wildcard Type, possibly with constraints."

  (array? [this])
  (primitive? [this])
  (typeName [this])
  (baseType [this]))

(defprotocol TypeDecl
  "Defiinition of a type (a Class, an Interface or an Enum)"
  (isEnum? [this])
  (isClass? [this])
  (isInterface? [this])
  (allFields [this]))

(defprotocol FieldDecl
  "Definition of Class, Enum or Interface Field. In the case of interface the field can only be static"
  (fieldName [this]))

(defprotocol Named
  (getName [this])
  (getQName [this]))