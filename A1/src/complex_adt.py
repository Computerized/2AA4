## @file complex_adt.py
#  @author scotta30
#  @brief 
#  @date 2021-01-13

import math

class ComplexT:
	realx, complexy = 0, 0

	def __init__(self,x,y):
		self.realx = x
		self.complexy = y

	def real(self):
		return self.realx

	def imag(self):
		return self.complexy

	def get_r(self):
		return math.sqrt(self.realx**2 + self.complexy**2)



