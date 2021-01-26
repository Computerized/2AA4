## @file complex_adt.py
#  @author Samia Anwar 
#  @brief Contains a class to manipulate complex numbers  
#  @Date January 21st 2021 

import math
import numpy 

## @brief An ADT for representing complex numbers
#  @details The complex numbers are represented in the form x + y*i
class ComplexT: 
	## @brief Constructor for ComplexT
	#  @details Creates a complext number representation based on given x and 
	#			y assuming they are always passed as real numbers. Real numbers
	# 			are in the set of complex numbers, therefore, y can be 0.  
	#  @param x is a real number constant 
	#  @param y is a real number coefficient of the square root of  -1. 

	def __init__(self, x, y):
		self.x = x 
		self.y = y

	## @brief Gets the constant x from a ComplexT
	#  @return A real number representing the constant of the instance
	def real(self):
		return self.x 

	## @brief Gets the constant x from a ComplexT
	#  @return A real number representing the coefficient of the instance
	def imag(self): 
		return self.y

	## @brief Calculates the absolute value of the complex number
	#  @return The absolute value of the complex number as a float  
	def get_r(self): 
		self.abs_value = math.sqrt(self.x*self.x + self.y*self.y)
		return self.abs_value

	## @brief Calculates the phase value of the complex number
	#  @details Checks for the location of imaginary number on the real-imaginary
	#   		plane, and performs the corresponding quadrant calculation 
	#  @return The phase of the complex number as a float in radians 
	def get_phi(self): 
		if self.x > 0: 
			self.phase = numpy.arctan(self.y/self.x)
		elif self.x < 0 and self.y >= 0 : 
			self.phase = numpy.arctan(self.y/self.x) + math.pi
		elif  self.x < 0 and self.y < 0: 
			self.phase = numpy.arctan(self.y/self.x) - math.pi
		elif self.x == 0 and self.y > 0: 
			self.phase = math.pi/2
		elif self.x == 0 and self.y < 0: 
			self.phase = -math.pi/2
		else: 
			self.phase = 0 
		return self.phase

	## @brief Checks if a different ComplexT object is equal to the current one
	#  @details Compares the real and imaginary compoenets of the two instances
	#  @param Accepts a ComplexT object, arg 
	#  @return A boolean corresponding to whether or not the two specified 
	#   	   objects are equal to one another, True for they are equal and False otherwise
	def equal(self, arg): 
		self._argx = arg.real()
		self._argy = arg.imag()
		return self._argx == self.x and self._argy == self.y
	
	## @brief Calculates the conjunct of the imaginary number 
	#  @return A ComplexT Object corresponding to the conjunct of the specific instance 		
	def conj(self): 
		return ComplexT (self.x, - self.y)

	## @brief Adds a different ComplexT object to the current object
	#  @details Adds the real and imaginary components of the two instances
	#  @param Accepts a ComplexT object, num_add
	#  @return A ComplexT object corresponding to the sum of the real and imaginary 
	#   	   and imaginary components
	def add(self, num_add): 
		self._newx = num_add.real() + self.x 
		self._newy = num_add.imag() + self.y 
		return ComplexT (self._newx, self._newy)

	## @brief Subtracts a different ComplexT object from the current object
	#  @details Individually subtracts the real and imaginary components of the two instances
	#  @param Accepts a ComplexT object, num_sub
	#  @return A ComplexT object corresponding to the difference of the real and imaginary 
	#   	   and imaginary components 
	def sub(self, num_sub):
		self._lessx = self.x - num_sub.real()
		self._lessy = self.y - num_sub.imag() 
		return ComplexT (self._lessx, self._lessy)

	## @brief Multiplies a different ComplexT object with the current object
	#  @details Arithmetically solved formula for (a + b*i) * (x + y*i) and seperated
	#			the constant (a*x - y*b) and the coefficient (b*x + a*y)
	#  @param Accepts a ComplexT object, num_mult which acts as a multiplier (a + bi)
	#  @return A ComplexT object corresponding to the product of two multipliers
	def mult(self, num_mult): 
		self._multx = num_mult.real() * self.x - self.y * num_mult.imag()
		self._multy = num_mult.imag() * self.x + self.real() * self.y
		return ComplexT (self._multx, self._multy)
	
	## @brief Calculates the reciprocal or inverse of the complex number 
	#  @details The formula was retrieved from www.suitcaseofdreams.net/Reciprocals.html
	#  @return A ComplexT object corresponding to the reciprocal of the current number
	def recip(self): 
		if self.x == 0 and self.y == 0: 
			return "The reciprocal of zero is undefined"
		else: 
			self._recipx = self.x / (self.x * self.x + self.y * self.y)
			self._recipy = - self.y / (self.x * self.x + self.y * self.y)
			return ComplexT(self._recipx, self._recipy)
	
	## @brief Divides a given complex number from the current number 
	#  @details The formula was retrieved from www.math-only-math.com/divisio-of-complex-numbers.html
	#  @param An object of ComplexT which acts as the divisor to the current dividend
	#  @return A ComplexT Object corresponding to the quotient of the current number over the input 
	def div(self, divisor): 
		self._divx = divisor.real()
		self._divy = divisor.imag()
		if self._divx == 0 and self._divy == 0: 
			return "Cannot divide by zero"
		else: 
			return ComplexT ( (self.x*self._divx + self.y*self._divy) 
						  	/ (self._divx * self._divx + self._divy*self._divy), 
						  	(self.y * self._divx - self._divy * self.x)
						  	/ (self._divx * self._divx + self._divy*self._divy))
	## @brief Calculates the square root of the current ComplexT object 
	#  @details The formula was retrieved from Stanley Rabinowitz's paper "How to find
	#           the Square Root of a Complex Number" published online, found via google search
	#  @return A ComplexT object corresponding to the square root of the current number 
	def sqrt(self): 
		self._sqrtx = math.sqrt((self.x) + math.sqrt(self.x*self.x + self.y*self.y)) / math.sqrt(2)
		self._sqrty = math.sqrt(math.sqrt(self.x*self.x + self.y*self.y) - self.x) / math.sqrt(2)
		return ComplexT (self._sqrtx, self._sqrty)





