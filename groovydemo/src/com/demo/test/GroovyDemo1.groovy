package com.demo.test

println("Hello demo JMJ from Groovy.....")

def a=25

println(a)
println(a.getClass())

String s ='Test String'
println(s)


//Closures
c= {
	println("Test closure...")
}

c.call()

c1= {n->
	println("Test closure...$n")
}
c1.call(20)


List l=[1, 2, 3]
println(l)

l<<5
println(l)


//methods
int product(int x, int y) {
	pro= x*y
	println("Product is: $pro")
	return pro
}

product(10,20)