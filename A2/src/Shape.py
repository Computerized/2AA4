## @file Shape.py
#  @author
#  @brief
#  @date

from abc import ABC, abstractmethod

class Shape(ABC):
    
    @abstractmethod
    def cm_x(self):
        pass

    def cm_y(self):
        pass

    def mass(self):
        pass

    def m_inert(self):
        pass