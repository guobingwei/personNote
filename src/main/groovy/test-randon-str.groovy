def getRandomStr = { type ->
	def random = new Random();
	String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
	String code = type
	10.times {
		def str = chars.charAt((int)random.nextInt(62))
		code += str
	}
	println code
}

getRandomStr('User-')