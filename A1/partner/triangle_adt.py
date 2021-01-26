## @file triangle_adt.py
#  @author Samia Anwar anwars10
#  @brief 
#  @date January 21st, 2021
from enum import Enum
import math 
## @brief An ADT for representing individual triangles
#  @details The triangle are represented by the lengths of their sides 
class TriangleT: 
	## @brief Constructor for Triangle T
	#  @details Creates a representation of triangle based on the length of its sides,
	#           I have assumed the inputs to be the set of real numbers not including zero.  
	#  @param The constructor takes 3 parameters corresponding to the three sides of a triangle
	def __init__(self, s1, s2, s3): 
		self.s1 = s1
		self.s2 = s2
		self.s3 = s3 
	## @brief Tells the user the side dimensions of the triangle
	#  @return An array of consisting of the length of each side 
	def get_sides(self): 
		return [self.s1, self.s2, self.s3]

	## @brief Tells the user if two TriangleT objects are equal to one another 
	#  @param Accepts a TriangleT type to compare with the current values 
	#  @return A boolean type true for the two are the same and false otherwise
	def equal(self, compTri): 
		return set(self.get_sides()) == set(compTri.get_sides())
	
	## @brief Tells the user the sum of all the sides of the triangle 
	#  @return An num type representing the perimetre of the triangle 
	def perim(self): 
		return (self.s1 + self.s2 + self.s3)

	## @brief Tells the user the area of the TriangleT referenced 
	#  @return A float representing the are of the TriangleT referenced 
	def area(self):
		if self.is_valid() : 
			return math.sqrt(self.perim() * (self.perim() - self.s1) * (self.perim() - self.s2) * (self.perim() - self.s3) )
		else: 
			return 0 

	## @brief Tells the user if the triangle referenced is valid 
	#  @details Determines the validity of the triangle based on the sides 
	#  @return A boolean value which is true if the triangle is valid, false otherwise
	def is_valid(self): 
		if (((self.s1 + self.s2) > self.s3) and ((self.s1 + self.s3) > self.s2) and ((self.s2 + self.s3) > self.s1)): 
			return True 
		else: 
			return False
	## @brief Tells the user one name for the type of triangle TriangleT referenced
	#  @details This program prioritises right angle triangle over the others, so 
	#           if the triangle is right, it will give only a right angle result and 
	#			not isoceles or scalene. 
	#  @return An instance of the TriType class corresponding to right/equilat/isoceles/or scalene
	def tri_type(self): 
		if (round(math.sqrt(self.s1 * self.s1  + self.s2 * self.s2)) == round(self.s3) 
			or round(math.sqrt(self.s1 * self.s1 + self.s3 * self.s3)) == round(self.s2) 
			or round(math.sqrt(self.s3 * self.s3 + self.s2 * self.s2)) == round(self.s1)): 
			return TriType.right
		elif (self.s1 == self.s2 and self.s2 == self.s3): 
			return TriType.equilat
		elif(self.s1 == self.s2 or self.s1 == self.s3 or self.s2 == self.s3): 
			return TriType.isoceles
		else: 
			return TriType.scalene

## @brief Creates an enumeration class to store the type of triangle to be referenced by 
#         tri_type method within TriangleT
class TriType(Enum): 
	equilat = 1
	isoceles = 2
	scalene = 3 
	right = 4 
