package com.demo.test

class GroovyDemoClass1 {
	def firstName, lastName
}

c= new GroovyDemoClass1(firstName:"Name 1", lastName:"Name 2")

println(c.firstName+" "+c.lastName)