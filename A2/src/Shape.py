## @file Shape.py
#  @author Alan Scott
#  @brief Parent class for various shapes
#  @date 16/02/2021

from abc import ABC, abstractmethod

class Shape(ABC):
    
    ## @brief Inheritable function for the x center of mass
    #  @details This function returns the x value of the center of mass. This function is
    #           inherited by any children of the Shape class. 
    @abstractmethod
    def cm_x(self):
        pass

    ## @brief Inheritable function for the y center of mass
    #  @details This function returns the y value of the center of mass. This function is
    #           inherited by any children of the Shape class. 
    @abstractmethod
    def cm_y(self):
        pass

    ## @brief Inheritable function for the mass of the shape
    #  @details This function returns the value of the mass. This function is inherited
    #           by any children of the Shape class. 
    @abstractmethod
    def mass(self):
        pass

    ## @brief Inheritable function for the moment of intertia
    #  @details This function returns the value of the mass. This function is inherited
    #           by any children of the Shape class.    
    @abstractmethod 
    def m_inert(self):
        pass