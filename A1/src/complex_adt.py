## @file complex_adt.py
#  @author scotta30
#  @brief 
#  @date 2021-01-13

import math

class ComplexT:
	x, y = 0, 0

	def __init__(self,x,y):
		self.x = x
		self.y = y

	def real(self):
		return self.x

	def imag(self):
		return self.y

	def get_r(self):
		return math.sqrt(self.x**2 + self.y**2)

	def get_phi(self):
		return 2*math.atan(self.y/(math.sqrt(self.x**2 + self.y**2)+self.x))

	def equal(self,obj):
		return (obj.real() == self.x) and (obj.imag() == self.y)

	def conj(self):
		return ComplexT(self.x,-self.y)

	def add(self,obj):
		return ComplexT(self.x + obj.real, self.y + obj.imag)

	def sub(self,obj):
		return ComplexT(self.x - obj.real, self.y - obj.imag)

	def mult(self,obj):
		r = self.x * obj.real - self.y * obj.imag
		i = self.x * obj.imag + self.y * obj.real
		return ComplexT(r, i)

	def recip(self):
		denom = self.x ** 2 + self.y ** 2
		return ComplexT(self.x/denom, -self.y/denom)

	def div(self, obj):
		return mult(obj.recip)

	def sqrt(self):
		r = get_r()
		real = math.sqrt((r + self.x)/2)
		imag = (self.y/math.abs(self.y))*math.sqrt((r - self.y)/2)
		return ComplexT(real,imag)
		



