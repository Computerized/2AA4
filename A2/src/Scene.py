## @file Scene.py
#  @author Alan Scott
#  @brief Scene class
#  @date 16/02/21
#  @details This class represents a "scene" with a shape. It then simulates the motion
#           of the body given forces, initial velocity and other factors.

from Shape import Shape
from scipy import integrate as odei


class Scene(Shape):

    ## @brief Scene constructor
    #  @details This method constructs the Scene object from a shape, forces and velocity.
    #  @param sprime Initial Shape
    #  @param fxprime Initial horizontal force
    #  @param sprime Initial vertical force
    #  @param sprime Initial horizontal velocity
    #  @param sprime Initial horizontal velocity
    def __init__(self, sprime, fxprime, fyprime, vxprime, vyprime):
        self.s, self.fx, self.fy = sprime, fxprime, fyprime
        self.vx, self.vy = vxprime, vyprime

    g = 9.81  # accel due to gravity (m/s^2)
    m = 1  # mass (kg)

    ## @brief Horizontal force function
    #  @details This function calculates the horizontal force.
    #  @param t The time given
    def Fx(self, t):
        return 5 if t < 5 else 0

    ## @brief Vertical force function
    #  @details This function calculates the vertical force.
    #  @param t The time given
    def Fy(self, t):
        return -self.g * self.m if t < 3 else self.g * self.m

    ## @brief Inherited cm_x function
    #  @details This function is declared here to prevent exceptions from abstract
    #           functions from the parent class. This method is a placeholder.
    def cm_x(self):
        pass

    ## @brief Inherited cm_y function
    #  @details This function is declared here to prevent exceptions from abstract
    #           functions from the parent class. This method is a placeholder.
    def cm_y(self):
        pass

    ## @brief Inherited mass function
    #  @details This function is declared here to prevent exceptions from abstract
    #           functions from the parent class. This method is a placeholder.
    def mass(self):
        pass

    ## @brief Inherited m_inert function
    #  @details This function is declared here to prevent exceptions from abstract
    #           functions from the parent class. This method is a placeholder.
    def m_inert(self):
        pass

    ## @brief Shape return function
    #  @details This function returns the Shape currently stored in the class.
    def get_shape(self):
        return self.s

    ## @brief Unbalanced forces return function
    #  @details This function returns the values of the x and y unbalanced forces.
    def get_unbal_forces(self):
        return self.fx, self.fy

    ## @brief Initial velocity return function
    #  @details This function returns the values of the x and y values of the initial
    #           velocities.
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief Shape setter function
    #  @details This function mutates the Shape stored in the class.
    #  @param sprime New shape
    def set_shape(self, sprime):
        self.s = sprime

    ## @brief Unbalanced forces setter function
    #  @details This function mutates the unbalanced forces stored in the class.
    #  @param fxprime New horizontal force
    #  @param fyprime New vertical force
    def set_unbal_forces(self, fxprime, fyprime):
        self.fx, self.fy = fxprime, fyprime

    ## @brief Initial velocity setter function
    #  @details This function mutates the initial velocities stored in the class.
    #  @param fxprime New horizontal velocity
    #  @param fyprime New vertical velocity
    def set_init_velo(self, vxprime, vyprime):
        self.vx, self.vy = vxprime, vyprime

    ## @brief Physics simulation function
    #  @details This function simulates the motion of the body. It does so by integrating the
    #           function over t through an approximation.
    #  @param tfinal Final value of t
    #  @param nsteps Number of increments
    def sim(self, tfinal, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * tfinal) / (nsteps - 1))
        out = odei.odeint(self.ode, [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
        return t, out

    ## @brief Ordinary differential equation constructor
    #  @details This function creates an ordinary differential equation.
    #  @param w Input array
    #  @param t Given time
    def ode(self, w, t):
        return [w[2], w[3], self.Fx(t) / self.s.mass(), self.Fy(t) / self.s.mass()]
