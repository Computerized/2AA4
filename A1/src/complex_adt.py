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



