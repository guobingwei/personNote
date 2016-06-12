def cl = this.class.classLoader

while(cl) {
	println cl
	cl = cl.parent
}